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

import com.prueba.micro.controller.dto.ClienteDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@Validated
public interface IClienteController {

	@PostMapping()
	ResponseEntity<?> clienteCrear(
			@Parameter(in = ParameterIn.DEFAULT, description = "Cliente", required = true, schema = @Schema()) @Valid @RequestBody ClienteDto body);

	@GetMapping()
	ResponseEntity<?> clienteObtener();

	@PutMapping()
	ResponseEntity<?> clienteActualizar(
			@Parameter(description = "Cliente", required = true, schema = @Schema()) @RequestBody ClienteDto body);

	@DeleteMapping("/{id}")
	ResponseEntity<?> eliminarCliente(@PathVariable("id") String id);

	@GetMapping("/{numeroIdentificacion}")
	ResponseEntity<?> clienteXIdentificacion(@PathVariable("numeroIdentificacion") String numeroIdentificacion);

}
