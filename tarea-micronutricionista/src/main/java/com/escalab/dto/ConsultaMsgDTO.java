package com.escalab.dto;

import java.io.Serializable;

public class ConsultaMsgDTO implements Serializable {

	private static final long serialVersionUID = 7537155368761683268L;
	
	private String nombrePaciente;
	private String edadPaciente;
	private String fechaConsulta;
	private String horaConsulta;
	private String especialidad;
	private String doctor;
	
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	
	public String getEdadPaciente() {
		return edadPaciente;
	}
	
	public void setEdadPaciente(String edadPaciente) {
		this.edadPaciente = edadPaciente;
	}
	
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getHoraConsulta() {
		return horaConsulta;
	}
	
	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	

}
