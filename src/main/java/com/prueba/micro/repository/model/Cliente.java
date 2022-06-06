package com.prueba.micro.repository.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dytype")
@DiscriminatorOptions(force = true)
@DiscriminatorValue("cliente")
@OnDelete(action = OnDeleteAction.CASCADE)
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="Idcliente", unique = true)
	private UUID Idcliente;
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@Column(name = "estado")
	private Boolean estado;

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getIdcliente() {
		return Idcliente;
	}

	public void setIdcliente(UUID idcliente) {
		Idcliente = idcliente;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ClienteDto [Idcliente=" + Idcliente + ", contrasenia=" + contrasenia + ", estado=" + estado + "]";
	}

}
