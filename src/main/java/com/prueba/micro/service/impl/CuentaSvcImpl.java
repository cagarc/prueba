package com.prueba.micro.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.micro.constants.TipoError;
import com.prueba.micro.controller.dto.CuentaDto;
import com.prueba.micro.repository.ifc.IClienteRepo;
import com.prueba.micro.repository.ifc.ICuentaRepo;
import com.prueba.micro.repository.model.Cuenta;
import com.prueba.micro.service.ifc.ICuentaSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.ConvertApis;

@Service
public class CuentaSvcImpl implements ICuentaSvc {

	@Autowired
	ICuentaRepo repository;
	@Autowired
	IClienteRepo repositoryCliente;

	@Override
	public CuentaDto cuentaCrear(CuentaDto cuentaDto) {
		// TODO Auto-generated method stub
		Cuenta cuenta = repository.save(ConvertApis.dtoToModel(cuentaDto));
		return ConvertApis.modelToDto(cuenta);
	}

	@Override
	public CuentaDto cuentaActualizar(CuentaDto cuentaDto) {
		// TODO Auto-generated method stub
		Cuenta cuenta = new Cuenta();
		String identi = repositoryCliente.consultarIdentificacion(cuentaDto.getIdentificacion()).getIdentificacion();
		if (identi == null) {
			cuenta = ConvertApis.dtoToModel(cuentaDto);
			cuenta = repository.save(cuenta);
		}
		return ConvertApis.modelToDto(cuenta);
	}

	@Override
	public boolean cuentaEliminar(String id) throws BusinessException {
		// TODO Auto-generated method stub
		Boolean recursoBorrado = false;
		UUID cuentaId = UUID.fromString(id.trim());
		if (repository.findById(cuentaId).isPresent()) {
			repository.deleteById(cuentaId);
			recursoBorrado = true;
		} else {
			throw new BusinessException("RECURSO_NO_ENCONTRADO", TipoError.SOLICITUD_INVALIDA);
		}

		return recursoBorrado;
	}

	@Override
	public String consultaIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		return repository.consultaIdentificacion(identificacion).getIdentificacion();
	}

	@Override
	public CuentaDto cuentaXIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		CuentaDto cuenta =ConvertApis.modelToDto(repository.consultaIdentificacion(identificacion));
		return cuenta;
	}

	@Override
	public List<Cuenta> CuentaDto(String identificacion) throws BusinessException {
		// TODO Auto-generated method stub
		
		List<Cuenta> cuentasCliente = repository.consultaXListaCuenta(identificacion);
		return cuentasCliente;
	}

}