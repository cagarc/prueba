package com.prueba.micro.repository.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.prueba.micro.controller.dto.TiposDeMovimiento;

@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_movimiento", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "fecha")
	private LocalDateTime fecha;

	@Column(name = "nombreCliente")
	private String cliente;

	@Column(name = "identificacioCliente")
	private String identificacionCliente;

	@Column(name = "numeroCuenta")
	private String numeroCuenta;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoMovimiento")
	private TiposDeMovimiento tipo;

	@Column(name = "saldoInicial")
	private double saldoInicial;

	@Column(name = "estado")
	private boolean estado;

	@Column(name = "movimiento")
	private double movimiento;

	@Column(name = "saldoDisponible")
	private double saldoDisponible;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TiposDeMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TiposDeMovimiento tipo) {
		this.tipo = tipo;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(double movimiento) {
		this.movimiento = movimiento;
	}

	public double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", identificacionCliente="
				+ identificacionCliente + ", numeroCuenta=" + numeroCuenta + ", tipo=" + tipo + ", saldoInicial="
				+ saldoInicial + ", estado=" + estado + ", movimiento=" + movimiento + ", saldoDisponible="
				+ saldoDisponible + "]";
	}

}
