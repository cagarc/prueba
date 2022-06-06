package com.prueba.micro.controller.ifc;

import java.sql.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.micro.controller.dto.MovimientoDto;
import com.prueba.micro.util.BusinessException;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

public interface IMovimientosControler {
	@PostMapping()
	ResponseEntity<?> movimientoCrear(
			@Parameter(in = ParameterIn.DEFAULT, description = "movimiento", required = true, schema = @Schema()) @Valid @RequestBody MovimientoDto body)
			throws BusinessException;

	@PutMapping()
	ResponseEntity<?> movimientoActualizar(
			@Parameter(description = "movimiento", required = true, schema = @Schema()) @RequestBody MovimientoDto body);

	@DeleteMapping("/{id}")
	ResponseEntity<?> movimientoDelete(@PathVariable("id") String id);
	
	@GetMapping("/{fecha1}/{fecha2}/{identificacion}")
	ResponseEntity<?> movimientoReporte(@PathVariable("fecha1") Date fecha1,@PathVariable("fecha2") Date fecha2,@PathVariable("identificacion") String identificacion);
}
