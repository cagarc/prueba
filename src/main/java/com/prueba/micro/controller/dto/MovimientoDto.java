package com.prueba.micro.controller.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovimientoDto {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("id")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime fecha;

	@JsonProperty("cliente")
	@JsonIgnore
	private String cliente;

	@JsonProperty("identificacionCliente")
	@JsonIgnore
	private String identificacionCliente;

	@JsonProperty("numeroCuenta")
	private String numeroCuenta;

	@JsonProperty("tipo")
	private TiposDeMovimiento tipo;

	@JsonProperty("saldoInicial")
	@JsonIgnore
	private double saldoInicial;

	@JsonProperty("estado")
	private boolean estado;

	@JsonProperty("movimiento")
	@DecimalMin(value = "0.00")
	private double movimiento;

	@JsonProperty("saldoDisponible")
	@JsonIgnore
	private double saldoDisponible;

}
