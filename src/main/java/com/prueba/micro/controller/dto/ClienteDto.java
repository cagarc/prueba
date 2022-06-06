package com.prueba.micro.controller.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ClienteDto extends PersonaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Idcliente")
	private UUID Idcliente;
	@JsonProperty("contrasenia")
	private String contrasenia;
	@JsonProperty("estado")
	private Boolean estado;

}
