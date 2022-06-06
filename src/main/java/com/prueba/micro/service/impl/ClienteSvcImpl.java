package com.prueba.micro.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.micro.controller.dto.ClienteDto;
import com.prueba.micro.controller.impl.ClienteControllerImpl;
import com.prueba.micro.repository.ifc.IClienteRepo;
import com.prueba.micro.repository.model.Cliente;
import com.prueba.micro.service.ifc.IClienteSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.ConvertApis;

@Service
public class ClienteSvcImpl implements IClienteSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteSvcImpl.class);

	@Autowired
	IClienteRepo repository;

	@Override
	public ClienteDto clienteCrear(ClienteDto clienteDto) throws BusinessException {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: clienteCrear"+clienteDto);
		Cliente cliente = repository.save(ConvertApis.dtoToModel(clienteDto));
		LOGGER.info(" PROCESO FIN: clienteCrear : PROCESO INGESO EXITOSO");
		return ConvertApis.modelToDto(cliente);
	}

	@Override
	public List<ClienteDto> clienteObtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDto clienteActualizar(ClienteDto clienteDto)  throws BusinessException{
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		LOGGER.info(" PROCESO INICIO: clienteActualizar-- DATOS"+clienteDto);
		String identi = repository.findByCliente(clienteDto.getIdentificacion());
		if (identi == null) {
			cliente =ConvertApis.dtoToModel(clienteDto);
			cliente = repository.save(cliente);
			LOGGER.info(" PROCESO FIN: clienteActualizar-- DATOS ACTUALIZADO ");
		}
		
		return ConvertApis.modelToDto(cliente);
	}

	@Override
	public ClienteDto eliminarCliente(String id) throws BusinessException{
		// TODO Auto-generated method stub
		UUID clienteId = UUID.fromString(id.trim());
		LOGGER.info(" PROCESO INICIO: eliminarCliente -- DATOS "+id);
		repository.deleteById(clienteId);
		LOGGER.info(" PROCESO FIN: eliminarCliente -- DATOS "+id);
		return null;
	}

	@Override
	public ClienteDto clienteXIdentificacion(String numeroIdentificacion) {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: eliminarCliente -- DATOS "+numeroIdentificacion);

		Cliente cliente = repository.consultarIdentificacion(numeroIdentificacion);
		LOGGER.info(" PROCESO FIN: eliminarCliente -- DATOS EXITOSO ");

		return ConvertApis.modelToDto(cliente);
	}

}
