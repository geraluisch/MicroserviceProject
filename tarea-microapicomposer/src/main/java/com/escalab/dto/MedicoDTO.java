package com.escalab.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MedicoDTO implements Serializable {

	private static final long serialVersionUID = 2430388646282743919L;
	
	private Integer idPaciente;
	private String dni;
	private String nombres;
	private String apellidos;	
	private LocalDateTime fecha_nacimiento;
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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
	
	public LocalDateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
}
