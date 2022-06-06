package com.prueba.micro.constants;

public enum TiposDeCuenta {

	AHORROS("AHORROS"), CORRIENTE("CORRIENTE");

	private String value;

	TiposDeCuenta(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static TiposDeCuenta fromValue(String value) {
		for (TiposDeCuenta b : TiposDeCuenta.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}
