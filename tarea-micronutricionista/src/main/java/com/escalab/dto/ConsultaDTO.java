package com.escalab.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.escalab.model.Nutricionista;

public class ConsultaDTO implements Serializable {
	
	private static final long serialVersionUID = -5460883361360569015L;
	
	private Integer idConsulta;
	private Nutricionista nutricionista;
	private PacienteDTO paciente;
	private LocalDateTime fecha;
	
	public Integer getIdConsulta() {
		return idConsulta;
	}
	
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public Nutricionista getNutricionista() {
		return nutricionista;
	}
	
	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
	
	public PacienteDTO getPaciente() {
		return paciente;
	}
	
	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	

}
