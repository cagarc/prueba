package com.prueba.micro.util;

import com.prueba.micro.constants.TipoError;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	TipoError error;

	public ApplicationException(String mensaje, TipoError error) {
		super(mensaje);
		this.error = error;
	}

	public ApplicationException(String mensaje, TipoError error, Throwable causa) {
		super(mensaje, causa);
		this.error = error;
	}

	public ApplicationException(String mensaje) {
		super(mensaje);
		this.error = TipoError.ERROR_INESPERADO;
	}

	public TipoError getError() {
		return error;
	}
}
