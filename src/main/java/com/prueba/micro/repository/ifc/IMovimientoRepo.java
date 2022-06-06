package com.prueba.micro.repository.ifc;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.micro.controller.dto.TiposDeMovimiento;
import com.prueba.micro.repository.model.Movimiento;

@Repository
public interface IMovimientoRepo extends JpaRepository<Movimiento, UUID> {

	@Query(value = "select identificacion	from movimientos u where u.identificacion = :identificacion", nativeQuery = true)
	String consultaIdentificacion(@Param("identificacion") String identificacion);

	@Query(value = "select COALESCE(sum(u.movimiento)) from movimientos u where DATE_TRUNC('day', u.fecha) = DATE_TRUNC('day', :fecha\\:\\:DATE) and u.NUMERO_CUENTA = :cuenta and u.tipo_movimiento = :#{#tiposDeMovimiento.name()}", nativeQuery = true)
	String cupoMovimientosDia(@Param("fecha") LocalDateTime fecha, @Param("tiposDeMovimiento") TiposDeMovimiento tipo,
			@Param("cuenta") String cuenta);

	@Query(value = "select NUMERO_CUENTA from movimientos u where u.NUMERO_CUENTA = :cuenta", nativeQuery = true)
	String consultaRegistroCuenta(@Param("cuenta") String cuenta);

	@Query(value = "select * from movimientos u where u.fecha \\:\\:DATE between :fecha1 and :fecha2 \\:\\:DATE and NUMERO_CUENTA =:cuenta order by fecha desc limit 1", nativeQuery = true)
	Movimiento consultaReporte(@Param("fecha1") Date fecha, @Param("fecha2") Date fecha2,
			@Param("cuenta") String cuenta);

	@Query(value = "SELECT saldo_disponible FROM public.movimientos WHERE numero_cuenta = :cuenta order by fecha desc  limit 1", nativeQuery = true)
	String consultaUltimoMovimiento(@Param("cuenta") String cuenta);

}
