package com.prueba.micro.controller.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.micro.constants.TiposDeCuenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CuentaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private UUID id;
	
	@JsonProperty("numeroCuenta")
	@Pattern(regexp = "[0-9]*")
	private String numeroCuenta;
	
	@JsonProperty("identificacion")
	@NotNull(message = "favor ingrese un numero identificacion")
	private String identificacion;
	
	@JsonProperty("cliente")
	private String cliente;
	
	@JsonProperty("tipoCuenta")
	private TiposDeCuenta tipoCuenta;
	
	@JsonProperty("saldoInicial")
	@DecimalMin(value = "0.00")
	private double saldoInicial;
	
	@JsonProperty("estado")
	private Boolean estado;

}
