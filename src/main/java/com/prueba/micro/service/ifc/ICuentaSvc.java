package com.prueba.micro.service.ifc;

import java.util.List;

import com.prueba.micro.controller.dto.CuentaDto;
import com.prueba.micro.repository.model.Cuenta;
import com.prueba.micro.util.BusinessException;

public interface ICuentaSvc {

	public CuentaDto cuentaCrear(CuentaDto clienteDto);

	public CuentaDto cuentaActualizar(CuentaDto clienteDto);

	public boolean cuentaEliminar(String id) throws BusinessException;

	public String consultaIdentificacion(String identificacion);
	
	public CuentaDto cuentaXIdentificacion(String identificacion);
	
	public List<Cuenta> CuentaDto(String identificacion) throws BusinessException;

}
