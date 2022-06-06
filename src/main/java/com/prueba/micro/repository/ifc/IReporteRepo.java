package com.prueba.micro.repository.ifc;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.micro.repository.model.Reporte;
@Repository
public interface IReporteRepo extends JpaRepository<Reporte, UUID>  {
	

	@Query(value = "SELECT M.FECHA,C.CLIENTE,C.NUMERO_CUENTA,M.TIPO_MOVIMIENTO,C.SALDO_INICIAL,C.ESTADO,M.VALOR,M.SALDO FROM PUBLIC.MOVIMIENTOS M, PUBLIC.CUENTA C WHERE M.IDENTIFICACION = C.IDENTIFICACION AND M.FECHA BETWEEN :fecha1 AND :fecha2"
			+ "", nativeQuery = true)
	List<Reporte> reporteMoviento(@Param("fecha1") Date fecha1,@Param("fecha2") Date fecha2);
}
