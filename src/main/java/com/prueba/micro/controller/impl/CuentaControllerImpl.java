package com.prueba.micro.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.micro.constants.TipoError;
import com.prueba.micro.controller.dto.CuentaDto;
import com.prueba.micro.controller.dto.RespuestaDto;
import com.prueba.micro.controller.ifc.ICuentaController;
import com.prueba.micro.repository.model.Cuenta;
import com.prueba.micro.service.ifc.IClienteSvc;
import com.prueba.micro.service.ifc.ICuentaSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.DataValidator;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("cuenta")
@Tag(name = "cuenta v1.0", description = "Servicio cuenta")
public class CuentaControllerImpl implements ICuentaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllerImpl.class);

	@Autowired
	ICuentaSvc service;
	
	@Autowired
	IClienteSvc serviceCliente;

	@Override
	public ResponseEntity<?> cuentaCrear(@Valid CuentaDto body) throws BusinessException {
		// TODO Auto-generated method stub
		String identificacion = body.getIdentificacion().trim();
		LOGGER.info("INICIA PROCESO DE CREAR CUENTA");
		String nombreCliente = serviceCliente.clienteXIdentificacion(identificacion).getNombre();
		LOGGER.info("FIN PROCESO DE CREAR CUENTA");
		if (nombreCliente == null) {
			throw new BusinessException(String.format("El cliente se encuentra registrado", body.getNumeroCuenta()),
					TipoError.SOLICITUD_INVALIDA);
		} else {

			CuentaDto cuenta = service.cuentaCrear(body);
			LOGGER.info("FIN PROCESO DE CREAR CUENTA");
			return ResponseEntity.ok(cuenta);
		}
	}

	@Override
	public ResponseEntity<?> cuentaActualizar(CuentaDto body) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			LOGGER.info("INICIA PROCESO DE ACTUALIZAR CUENTA");
			service.cuentaActualizar(body);
			LOGGER.info("FIN PROCESO DE ACTUALIZAR CUENTA");
			respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("200").repuestaError("SE ACTUALIZAR CON EXITO"), HttpStatus.OK);

		} catch (Exception ex) {
			LOGGER.error("ERROR cuentaActualizar {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").codigoError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

	@Override
	public ResponseEntity<?> cuentaEliminar(String id) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("INICIA PROCESO DE CONSULTAR CUENTA");
			Boolean cuenta = service.cuentaEliminar(id);
			LOGGER.info("FIN PROCESO DE ACTUALIZAR CUENTA");
			return new ResponseEntity<Boolean>(cuenta, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.info("ERROR PROCESO DE ACTUALIZAR CUENTA");
			return DataValidator.validarResultado(e);
		} catch (Exception e) {
			LOGGER.error("ERROR cuentaActualizar {}", e.getMessage());
			return new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").repuestaError("ERROR_INTERNO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> cuentas(String identificacion) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("INICIA PROCESO DE CONSULTAR CUENTA");
			List<Cuenta>  cuenta = service.CuentaDto(identificacion);
			LOGGER.info("FIN PROCESO DE CONSULTAR CUENTA");
			return new ResponseEntity<>(cuenta, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.info("ERROR PROCESO DE CONSULTAR CUENTA");
			return DataValidator.validarResultado(e);
		} catch (Exception e) {
			LOGGER.error("ERROR cuenta {}", e.getMessage());
			return new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").repuestaError("ERROR_INTERNO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
