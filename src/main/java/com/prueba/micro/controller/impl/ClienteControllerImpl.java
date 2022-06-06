package com.prueba.micro.controller.impl;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.micro.controller.dto.ClienteDto;
import com.prueba.micro.controller.dto.RespuestaDto;
import com.prueba.micro.controller.ifc.IClienteController;
import com.prueba.micro.service.ifc.IClienteSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.ClienteValidator;
import com.prueba.micro.util.DataValidator;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("cliente")
@Tag(name = "cliente v1.0", description = "Servicio cliente")
public class ClienteControllerImpl implements IClienteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllerImpl.class);

	@Autowired
	IClienteSvc service;

	@Override
	public ResponseEntity<?> clienteCrear(@Valid ClienteDto body) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			LOGGER.info("INICIA PROCESO DE CREAR CLIENTE");
			ClienteDto cliente = service.clienteCrear(body);
			respuesta = ClienteValidator.validarResultado(cliente);
			LOGGER.info("FIN PROCESO DE CREAR CLIENTE");
		} catch (BusinessException e) {
			LOGGER.error("ERROR DE PROCESO DE CREAR CLIENTE", e.getMessage());
			return DataValidator.validarResultado(e);
		} catch (Exception ex) {
			LOGGER.error("ERROR clienteCrear {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(new RespuestaDto().codigoError("500")
					.codigoError("ERROR INTERNAL SERVE").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("FINALIZA PROCESO DE CREAR CLIENTE");
		return respuesta;
	}

	@Override
	public ResponseEntity<?> clienteObtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> clienteActualizar(ClienteDto clienteDto) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			service.clienteActualizar(clienteDto);
			respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("200").repuestaError("SE ACTUALIZAR CON EXITO"), HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.error("ERROR DE NEGOCIO EN ACTUALIZAR CLIENTE", e.getMessage());
			return DataValidator.validarResultado(e);
		} catch (Exception ex) {
			LOGGER.error("ERROR clienteActualizar {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").codigoError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

	@Override
	public ResponseEntity<?> eliminarCliente(String id) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			service.eliminarCliente(id);
			respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("200").repuestaError("SE ELIMINO CON EXITO"), HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.error("ERROR DE NEGOCIO ELIMINAR CLIENTE POR ID ->{}", e.getMessage());
			return DataValidator.validarResultado(e);
		} catch (Exception ex) {
			LOGGER.error("ERROR eliminarCliente {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").codigoError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

	@Override
	public ResponseEntity<?> clienteXIdentificacion(String numeroIdentificacion) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			ClienteDto cliente = service.clienteXIdentificacion(numeroIdentificacion);
			respuesta = ResponseEntity.ok(cliente);

		} catch (Exception ex) {
			LOGGER.error("ERROR clienteXIdentificacion {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").codigoError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

}
