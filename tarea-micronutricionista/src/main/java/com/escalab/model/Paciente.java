package com.escalab.model;

import java.time.LocalDateTime;

public class Paciente {	
	
	private Integer idPaciente;	
	private String dni;	
	private String nombres;	
	private String apellidos;	
	private LocalDateTime fecha_nacimiento;
	private String puerto;	
	
	public Paciente() {}
	
	public Paciente(Integer idPaciente, String dni, String nombres, String apellidos, LocalDateTime fecha_nacimiento, String puerto) {
		super();
		this.idPaciente = idPaciente;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.puerto = puerto;
	}

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
	
	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}


	
}
