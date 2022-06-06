package com.prueba.micro.controller.impl;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.micro.controller.dto.MovimientoDto;
import com.prueba.micro.controller.dto.MovimientosClienteDto;
import com.prueba.micro.controller.dto.RespuestaDto;
import com.prueba.micro.controller.ifc.IMovimientosControler;
import com.prueba.micro.repository.model.Reporte;
import com.prueba.micro.service.ifc.IMovimientosSvc;
import com.prueba.micro.util.BusinessException;
import com.prueba.micro.util.DataValidator;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("movimiento")
@Tag(name = "movimiento v1.0", description = "Servicio movimiento")
public class MovimientosControlerImpl implements IMovimientosControler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllerImpl.class);

	@Autowired
	IMovimientosSvc service;

	@Override
	public ResponseEntity<?> movimientoCrear(@Valid MovimientoDto body) throws BusinessException {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			LOGGER.info("INICIA PROCESO DE CREAR MOVIMIENTO");
			MovimientoDto moviento = service.movimientoCrear(body);
			respuesta = new ResponseEntity<MovimientoDto>(moviento, HttpStatus.OK);
			LOGGER.info("FIN PROCESO DE CREAR MOVIMIENTO");
		} catch (BusinessException e) {
			LOGGER.error("ERROR movimientoCrear {}", e.getMessage());
			return DataValidator.validarResultado(e);
		} catch (Exception ex) {
			LOGGER.error("ERROR movimientoCrear {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").repuestaError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

	@Override
	public ResponseEntity<?> movimientoActualizar(MovimientoDto body) {
		// TODO Auto-generated method stub
		ResponseEntity<?> respuesta = null;
		try {
			LOGGER.info("INICIA PROCESO DE ACTUALIZAR MOVIMIENTO");
			MovimientoDto moviento = service.movimientoActualizar(body);
			respuesta = new ResponseEntity<MovimientoDto>(moviento, HttpStatus.OK);
			LOGGER.info("FIN PROCESO DE ACTUALIZAR MOVIMIENTO");
		} catch (Exception ex) {
			LOGGER.error("ERROR movimientoActualizar {}", ex.getMessage());
			return respuesta = new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").codigoError("ERROR INTERNAL SERVE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respuesta;
	}

	@Override
	public ResponseEntity<?> movimientoReporte(Date fecha1, Date fecha2,String identificacion) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("INICIA PROCESO DE REPORTE");
			List<MovimientosClienteDto> cuenta = service.movimientoReporte(fecha1, fecha2,identificacion);
			LOGGER.info("FIN PROCESO DE REPORTE");
			return new ResponseEntity<List<MovimientosClienteDto>>(cuenta, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("ERROR REPORTE {}", e.getMessage());
			return new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").repuestaError("ERROR_INTERNO" + e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> movimientoDelete(String id) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("INICIA PROCESO DE DELETE");
			Boolean cuenta = service.movimientoEliminar(id);
			LOGGER.info("FIN PROCESO DE DELETE");
			return new ResponseEntity<Boolean>(cuenta, HttpStatus.OK);
		} catch (BusinessException e) {
			return DataValidator.validarResultado(e);
		} catch (Exception e) {
			LOGGER.error("ERROR DELETE {}", e.getMessage());
			return new ResponseEntity<RespuestaDto>(
					new RespuestaDto().codigoError("500").repuestaError("ERROR_INTERNO"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
