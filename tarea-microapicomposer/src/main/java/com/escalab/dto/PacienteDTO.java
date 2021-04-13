package com.escalab.dto;

import java.io.Serializable;

public class PacienteDTO implements Serializable {

	private static final long serialVersionUID = -8251088955923094020L;

	private Integer idNutricionista;
	private String dni;
	private String nombres;	
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
