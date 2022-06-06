package com.prueba.micro.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.prueba.micro.controller.dto.ClienteDto;
import com.prueba.micro.controller.dto.CuentaDto;
import com.prueba.micro.controller.dto.MovimientoDto;
import com.prueba.micro.controller.dto.MovimientosClienteDto;
import com.prueba.micro.repository.model.Cliente;
import com.prueba.micro.repository.model.Cuenta;
import com.prueba.micro.repository.model.Movimiento;

public class ConvertApis {

	public static final ClienteDto modelToDto(Cliente cliente) {
		return new ModelMapper().map(cliente, ClienteDto.class);
	}

	public static final Cliente dtoToModel(ClienteDto cliente) {
		return new ModelMapper().map(cliente, Cliente.class);
	}

	public static final CuentaDto modelToDto(Cuenta cuenta) {
		return new ModelMapper().map(cuenta, CuentaDto.class);
	}

	public static final Cuenta dtoToModel(CuentaDto cuenta) {
		return new ModelMapper().map(cuenta, Cuenta.class);
	}

	public static final MovimientoDto modelToDto(Movimiento movimientoDto) {
		return new ModelMapper().map(movimientoDto, MovimientoDto.class);
	}
	
	public static final MovimientosClienteDto convertmodelToDto(Movimiento movimientoDto) {
		return new ModelMapper().map(movimientoDto, MovimientosClienteDto.class);
	}

	public static final Movimiento dtoToModel(MovimientoDto movimiento) {
		return new ModelMapper().map(movimiento, Movimiento.class);
	}
	
	public static final List<MovimientosClienteDto> listdtoToModel(List<Movimiento> movimiento) {
		return movimiento.stream().map(mov -> (convertmodelToDto(mov))).collect(Collectors.toList()); //new ModelMapper().map(movimiento, MovimientoDto.class);
	}
	
	
}
