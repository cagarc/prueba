package com.prueba.micro.repository.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prueba.micro.constants.TiposDeCuenta;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcuenta", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "numeroCuenta", unique = true)
	private String numeroCuenta;

	@Column(name = "identificacion")
	private String identificacion;

	@Column(name = "cliente")
	private String cliente;

	@Column(name = "tipoCuenta")
	private TiposDeCuenta tipoCuenta;

	@Column(name = "saldoInicial")
	private double saldoInicial;

	@Column(name = "estado")
	private Boolean estado;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public TiposDeCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TiposDeCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", numeroCuenta=" + numeroCuenta + ", identificacion=" + identificacion
				+ ", cliente=" + cliente + ", tipoCuenta=" + tipoCuenta + ", saldoInicial=" + saldoInicial + ", estado="
				+ estado + "]";
	}

}
