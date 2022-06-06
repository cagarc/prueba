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
public class PersonaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private UUID id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("genero")
	private Genero genero;
	@JsonProperty("edad")
	private int edad;
	@JsonProperty("identificacion")
	private String identificacion;
	@JsonProperty("direccion")
	private String direccion;
	@JsonProperty("telefono")
	private String telefono;

}
