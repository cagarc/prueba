package com.prueba.micro.controller.ifc;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.prueba.micro.controller.dto.CuentaDto;
import com.prueba.micro.util.BusinessException;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@Validated
public interface ICuentaController {
	@PostMapping()
	ResponseEntity<?> cuentaCrear(
			@Parameter(in = ParameterIn.DEFAULT, description = "cuenta", required = true, schema = @Schema()) @Valid @RequestBody CuentaDto body)
			throws BusinessException;

	@PutMapping()
	ResponseEntity<?> cuentaActualizar(
			@Parameter(description = "Cuenta", required = true, schema = @Schema()) @RequestBody CuentaDto body);

	@DeleteMapping("/{id}")
	ResponseEntity<?> cuentaEliminar(@PathVariable("id") String id);
	
	@GetMapping("/{identificacion}")
	ResponseEntity<?> cuentas(@PathVariable("identificacion") String identificacion);
}
