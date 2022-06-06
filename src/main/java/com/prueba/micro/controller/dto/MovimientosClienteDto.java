package com.prueba.micro.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovimientosClienteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@JsonIgnore
	private UUID id;

	@JsonProperty("fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime fecha;

	@JsonProperty("cliente")
	private String cliente;

	@JsonProperty("identificacionCliente")
	private String identificacionCliente;

	@JsonProperty("numeroCuenta")
	private String numeroCuenta;

	@JsonProperty("tipoCuenta")
	private TiposDeCuenta tipoCuenta;

	@JsonProperty("saldoInicial")
	private double saldoInicial;

	@JsonProperty("estado")
	private boolean estado;

	@JsonProperty("movimiento")
	@DecimalMin(value = "0.00")
	private double movimiento;

	@JsonProperty("saldoDisponible")
	private double saldoDisponible;

}
