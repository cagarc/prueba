package com.prueba.micro.service.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.prueba.micro.constants.TipoError;
import com.prueba.micro.controller.dto.MovimientoDto;
import com.prueba.micro.controller.dto.MovimientosClienteDto;
import com.prueba.micro.controller.dto.TiposDeMovimiento;
import com.prueba.micro.repository.ifc.IClienteRepo;
import com.prueba.micro.repository.ifc.ICuentaRepo;
import com.prueba.micro.repository.ifc.IMovimientoRepo;
import com.prueba.micro.repository.impl.ReportRepo;
import com.prueba.micro.repository.model.Cuenta;
import com.prueba.micro.repository.model.Movimiento;
import com.prueba.micro.repository.model.Persona;
import com.prueba.micro.repository.model.Reporte;
import com.prueba.micro.service.ifc.IMovimientosSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.ConvertApis;

@Service
public class MovimientosSvcImpl implements IMovimientosSvc {

	@Autowired
	ICuentaRepo repositorycuenta;

	@Autowired
	IMovimientoRepo respository;

	@Autowired
	ReportRepo repo;

	@Autowired
	IClienteRepo clienterepor;

	public static final Double DIARIO_DEBITOS = 1000.00;

	@Override
	public MovimientoDto movimientoCrear(MovimientoDto movimientoDto) throws BusinessException {
		String numeroDeCuenta = movimientoDto.getNumeroCuenta().trim();
		Cuenta datosCuenta = repositorycuenta.consultaXCuenta(numeroDeCuenta);
		String registro = respository.consultaUltimoMovimiento(numeroDeCuenta);

		if (datosCuenta == null) {
			throw new BusinessException(String.format(
					"El número de cuenta: [%s] no se encuentra registrado, por favor verifique el numero.",
					movimientoDto.getNumeroCuenta()), TipoError.SOLICITUD_INVALIDA);

		}
		if (!(numeroDeCuenta.equals(datosCuenta.getNumeroCuenta()))) {
			throw new BusinessException(String.format(
					"El número de cuenta: [%s] no se encuentra registrado, por favor verifique el numero.",
					movimientoDto.getNumeroCuenta()), TipoError.SOLICITUD_INVALIDA);
		}

		Persona datosCliente = clienterepor.consultarIdentificacion(datosCuenta.getIdentificacion());

		LocalDateTime FechaMvmt = movimientoDto.getFecha();
		if (movimientoDto.getTipo().equals(TiposDeMovimiento.RETIRO)) {
			if (datosCuenta.getSaldoInicial() == 0.00
					|| datosCuenta.getSaldoInicial() < movimientoDto.getMovimiento()) {
				throw new BusinessException(String.format("Saldo no disponible", movimientoDto.getNumeroCuenta()),
						TipoError.SOLICITUD_INVALIDA);

			}
			String montoMovimientos = respository.cupoMovimientosDia(FechaMvmt, TiposDeMovimiento.RETIRO,
					numeroDeCuenta);
			if (montoMovimientos != null && Math.abs(Double.parseDouble(montoMovimientos)) > DIARIO_DEBITOS) {
				throw new BusinessException(String.format("Cupo diario Excedido", movimientoDto.getNumeroCuenta()),
						TipoError.SOLICITUD_INVALIDA);
			}

			movimientoDto.setCliente(datosCliente.getNombre());
			movimientoDto.setIdentificacionCliente(datosCliente.getIdentificacion());
			movimientoDto.setSaldoInicial(datosCuenta.getSaldoInicial());
			double valor = registro == null ? datosCuenta.getSaldoInicial() : Double.parseDouble(registro);
			if (valor == 0.00) {
				throw new BusinessException(String.format("Saldo no disponible", movimientoDto.getNumeroCuenta()),
						TipoError.SOLICITUD_INVALIDA);
			}

			movimientoDto.setSaldoDisponible((valor - movimientoDto.getMovimiento()));
			movimientoDto.setMovimiento(-(movimientoDto.getMovimiento()));
			Movimiento movimientos = respository.save(ConvertApis.dtoToModel(movimientoDto));

			return ConvertApis.modelToDto(movimientos);

		}

		movimientoDto.setMovimiento(movimientoDto.getMovimiento());
		movimientoDto.setCliente(datosCliente.getNombre());
		movimientoDto.setIdentificacionCliente(datosCliente.getIdentificacion());
		movimientoDto.setSaldoInicial(datosCuenta.getSaldoInicial());
		double valor = registro == null ? datosCuenta.getSaldoInicial() : Double.parseDouble(registro);
		movimientoDto.setSaldoDisponible((valor + movimientoDto.getMovimiento()));
		Movimiento movimientos = respository.save(ConvertApis.dtoToModel(movimientoDto));
		return ConvertApis.modelToDto(movimientos);
	}

	@Override
	public MovimientoDto movimientoActualizar(MovimientoDto movimiento) {
		// TODO Auto-generated method stub
		Movimiento movimient = new Movimiento();
		String identi = respository.consultaRegistroCuenta(movimiento.getNumeroCuenta());
		if (identi != null) {
			movimient = ConvertApis.dtoToModel(movimiento);
			movimient = respository.save(movimient);
		}
		return ConvertApis.modelToDto(movimient);
	}

	@Override
	public boolean movimientoEliminar(String id) throws BusinessException {
		// TODO Auto-generated method stub
		Boolean recursoBorrado = false;
		UUID movimientoId = UUID.fromString(id.trim());
		if (respository.findById(movimientoId).isPresent()) {
			respository.deleteById(movimientoId);
			recursoBorrado = true;
		} else {
			throw new BusinessException("RECURSO_NO_ENCONTRADO", TipoError.SOLICITUD_INVALIDA);
		}

		return recursoBorrado;
	}

	@Override
	public String movimientoIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovimientosClienteDto> movimientoReporte(Date fecha1, Date fecha2, String identificacion) {
		// TODO Auto-generated method stub
		List<MovimientosClienteDto> listaMovimiento = new ArrayList<>();
		MovimientosClienteDto item;
		List<Cuenta> cuentasCliente = repositorycuenta.consultaXListaCuenta(identificacion);
		for (Cuenta cuenta : cuentasCliente) {
			Movimiento moviento = respository.consultaReporte(fecha1, fecha2, cuenta.getNumeroCuenta());
			
			if (moviento != null) {
				item = new MovimientosClienteDto();
				item.setCliente(moviento.getCliente());
				item.setEstado(cuenta.getEstado());
				item.setFecha(moviento.getFecha());
				item.setId(moviento.getId());
				item.setIdentificacionCliente(identificacion);
				item.setMovimiento(moviento.getMovimiento());
				item.setNumeroCuenta(moviento.getNumeroCuenta());
				item.setSaldoDisponible(moviento.getSaldoDisponible());
				item.setSaldoInicial(moviento.getSaldoInicial());
				item.setTipoCuenta(cuenta.getTipoCuenta());
				
				listaMovimiento.add(item);
			}

		}

		return listaMovimiento;
	}

}
