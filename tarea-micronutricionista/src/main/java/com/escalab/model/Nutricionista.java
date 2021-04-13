package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNutricionista;
	
	@Size(min = 5, message = "El dni debe tener minimo 5 caracteres")
	@Column(name = "dni", length = 20, nullable = false)
	private String dni;
	
	@Size(min = 3, message = "El campo nombres debe tener minimo 3 caracteres")
	@Column(name = "nombres", length = 50, nullable = false)
	private String nombres;
	
	@Size(min = 3, message = "El campo apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;

	public Integer getIdNutricionista() {
		return idNutricionista;
	}

	public void setIdNutricionista(Integer idNutricionista) {
		this.idNutricionista = idNutricionista;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}	
	
}
