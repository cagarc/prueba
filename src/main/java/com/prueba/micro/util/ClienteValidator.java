/**
 * 
 */
package com.prueba.micro.util;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.micro.controller.dto.ClienteDto;
import com.prueba.micro.controller.dto.RespuestaDto;
import com.prueba.micro.repository.model.Cliente;

public final class ClienteValidator {

	private ClienteValidator() {

	}


	public static ResponseEntity<RespuestaDto> validarResultadoaByCreate(@Valid ClienteDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("500").repuestaError("El recurso no pudo ser creado"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(
				new RespuestaDto().codigoError("201")
						.repuestaError(String.format("ID del recurso creado: [%s]", resultado.getId().toString())),
				HttpStatus.CREATED);
	}

	public static ResponseEntity<Object> validarResultado(List<?> resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(new RespuestaDto().codigoError("500")
					.repuestaError("ALCO OCURRIO, NO PODIMOS OBTENER LO SOLICITADO"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("204").repuestaError("NO SE ENCONTRARON RESULTADOS"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}

	/**
	 * VALIDAMOS EL CONTENIDO DEL RESULTADOS CUANDO ES "CLIENTE" PARA DEFINIR EL
	 * CONDIGO HTTP CORRESPONDIENTE
	 * 
	 * @param resultado
	 * @return
	 */
	public static ResponseEntity<Object> validarResultado(Cliente resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("500").repuestaError("LA SOLICITUD NO SE PROCESO EXITOSAMENTE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(resultado);
	}

	public static ResponseEntity<RespuestaDto> validarResultado(@Valid ClienteDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("500").repuestaError("LA PETICION NO SE PROCESADO EXITOSAMENTE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(new RespuestaDto().codigoError("200").repuestaError("PROCESO EXITOSO"));
	}

	public static ResponseEntity<Object> validarResultado(Optional<Cliente> resultado) {
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("204").repuestaError("NO SE ENCONTRARON RESULTADOS"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}

	public static ResponseEntity<RespuestaDto> validarResultadoaByUpdate(@Valid ClienteDto resultado, UUID uuid,
			String identificacion) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new RespuestaDto().codigoError("404").repuestaError(String
							.format("El recurso ID: [%s] - identificacion : [%s] no existe", uuid, identificacion)),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RespuestaDto().codigoError("200")
				.repuestaError(String.format("Usuario con el ID: [%s] - identificacion : [%s] se actualizo con éxito",
						resultado.getId().toString(), resultado.getIdentificacion())),
				HttpStatus.OK);
	}

}
