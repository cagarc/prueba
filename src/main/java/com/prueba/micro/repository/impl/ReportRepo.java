package com.prueba.micro.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ReportRepo {

	@PersistenceContext
	private EntityManager em;

	public Object prueba () {
		List<?> movies = em.createQuery("SELECT M.FECHA,C.CLIENTE,C.NUMERO_CUENTA,M.TIPO_MOVIMIENTO,C.SALDO_INICIAL,C.ESTADO,M.VALOR,M.SALDO FROM movimientos M, CUENTA C WHERE M.IDENTIFICACION = C.IDENTIFICACION ")
				.setParameter(1, "English").getResultList();
		return movies;
	}

}
