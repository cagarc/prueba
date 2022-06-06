package com.prueba.micro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.micro.controller.dto.RespuestaDto;


public class DataValidator {
	public static final boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}


	public static ResponseEntity<RespuestaDto> validarResultado(BusinessException ex) {
		ResponseEntity<RespuestaDto> respuesta;
		switch (ex.getError()) {
	
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("400").repuestaError(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("502").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("503").repuestaError(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
		default:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("500").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

	
	public static ResponseEntity<RespuestaDto> validarResultado(ApplicationException ex) {
		ResponseEntity<RespuestaDto> respuesta;
		switch (ex.getError()) {
	
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("400").repuestaError(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("502").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("503").repuestaError(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
	
		default:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("500").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

	public static ResponseEntity<Object> validarResultadoObj(Object exe) {
		ResponseEntity<Object> respuesta;
		BusinessException ex = (BusinessException) exe;
		switch (ex.getError()) {
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("400").repuestaError(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("502").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("503").repuestaError(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
	
		default:
			respuesta = new ResponseEntity<>(new RespuestaDto().codigoError("500").repuestaError(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

}
