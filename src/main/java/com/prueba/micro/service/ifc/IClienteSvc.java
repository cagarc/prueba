package com.prueba.micro.service.ifc;

import java.util.List;

import com.prueba.micro.controller.dto.ClienteDto;
import com.prueba.micro.util.BusinessException;

public interface IClienteSvc {

	public ClienteDto clienteCrear(ClienteDto clienteDto) throws BusinessException;

	public List<ClienteDto> clienteObtener();

	public ClienteDto clienteActualizar(ClienteDto clienteDto)  throws BusinessException;

	public ClienteDto eliminarCliente(String id)throws BusinessException;

	public ClienteDto clienteXIdentificacion(String numeroIdentificacion);

}
