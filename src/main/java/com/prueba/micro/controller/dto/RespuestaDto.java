package com.prueba.micro.controller.dto;

public class RespuestaDto {

	private String codigoError;

	private String repuestaError;

	public RespuestaDto codigoError(String codigoError) {
		this.codigoError = codigoError;
		return this;
		// TODO Auto-generated constructor stub
	}

	public RespuestaDto repuestaError(String repuestaError) {
		this.repuestaError = repuestaError;
		return this;
		// TODO Auto-generated constructor stub
	}

	public RespuestaDto() {
		super();
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getRepuestaError() {
		return repuestaError;
	}

	public void setRepuestaError(String repuestaError) {
		this.repuestaError = repuestaError;
	}

}
