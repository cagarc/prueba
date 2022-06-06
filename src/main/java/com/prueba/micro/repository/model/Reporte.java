package com.prueba.micro.repository.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reporte")
public class Reporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idreporte", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "FECHA")
	private Date FECHA;
	
	@Column(name = "CLIENTE")
	private String CLIENTE;
	
	@Column(name = "NUMERO_CUENTA")
	private String NUMERO_CUENTA;
	
	@Column(name = "TIPO_MOVIMIENTO")
	private String TIPO_MOVIMIENTO;
	
	@Column(name = "SALDO_INICIAL")
	private String SALDO_INICIAL;
	
	@Column(name = "ESTADO")
	private String ESTADO;
	
	@Column(name = "VALOR")
	private String VALOR;
	
	@Column(name = "SALDO")
	private String SALDO;

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}

	public String getCLIENTE() {
		return CLIENTE;
	}

	public void setCLIENTE(String cLIENTE) {
		CLIENTE = cLIENTE;
	}

	public String getNUMERO_CUENTA() {
		return NUMERO_CUENTA;
	}

	public void setNUMERO_CUENTA(String nUMERO_CUENTA) {
		NUMERO_CUENTA = nUMERO_CUENTA;
	}

	public String getTIPO_MOVIMIENTO() {
		return TIPO_MOVIMIENTO;
	}

	public void setTIPO_MOVIMIENTO(String tIPO_MOVIMIENTO) {
		TIPO_MOVIMIENTO = tIPO_MOVIMIENTO;
	}

	public String getSALDO_INICIAL() {
		return SALDO_INICIAL;
	}

	public void setSALDO_INICIAL(String sALDO_INICIAL) {
		SALDO_INICIAL = sALDO_INICIAL;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public String getVALOR() {
		return VALOR;
	}

	public void setVALOR(String vALOR) {
		VALOR = vALOR;
	}

	public String getSALDO() {
		return SALDO;
	}

	public void setSALDO(String sALDO) {
		SALDO = sALDO;
	}

	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reporte [id=" + id + ", FECHA=" + FECHA + ", CLIENTE=" + CLIENTE + ", NUMERO_CUENTA=" + NUMERO_CUENTA
				+ ", TIPO_MOVIMIENTO=" + TIPO_MOVIMIENTO + ", SALDO_INICIAL=" + SALDO_INICIAL + ", ESTADO=" + ESTADO
				+ ", VALOR=" + VALOR + ", SALDO=" + SALDO + "]";
	}



}
