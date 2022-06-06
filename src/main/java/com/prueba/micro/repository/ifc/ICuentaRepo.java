package com.prueba.micro.repository.ifc;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.micro.repository.model.Cuenta;

@Repository
public interface ICuentaRepo extends JpaRepository<Cuenta, UUID> {

	@Query(value = "select identificacion	from cuenta u where u.identificacion = :identificacion", nativeQuery = true)
	Cuenta consultaIdentificacion(@Param("identificacion") String identificacion);

	@Query(value = "select * from cuenta u where u.numero_cuenta = :cuentas", nativeQuery = true)
	Cuenta consultaXCuenta(@Param("cuentas") String cuentas);
	
	@Query(value = "select * from cuenta u where u.identificacion = :identificacion", nativeQuery = true)
	List<Cuenta> consultaXListaCuenta(@Param("identificacion") String identificacion);
	
}
