package com.prueba.micro.repository.ifc;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.micro.repository.model.Cliente;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, UUID> {

	@Query(value = "select u.identificacion from persona u where u.identificacion = :Idcliente", nativeQuery = true)
	String findByCliente(@Param("Idcliente") String id);

	@Query(value = "select Idcliente, contrasenia, estado, c.id, p.direccion, p.edad, p.genero, identificacion, p.nombre, p.telefono\r\n"
			+ "			from persona p inner join cliente c on c.id = p.id\r\n"
			+ "				where upper(p.identificacion) = :numIdentificacion", nativeQuery = true)
	Cliente consultarIdentificacion(@Param("numIdentificacion") String numIdentificacion);
}
