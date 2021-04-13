package com.escalab.dto;

import java.io.Serializable;
import java.util.List;

public class MedicoPacienteDTO implements Serializable {

	private static final long serialVersionUID = 4946751713931064211L;
	
	private List<MedicoDTO> listaMedico;
	private List<PacienteDTO> listaPaciente;
	
	public List<MedicoDTO> getListaMedico() {
		return listaMedico;
	}
	
	public void setListaMedico(List<MedicoDTO> listaMedico) {
		this.listaMedico = listaMedico;
	}
	
	public List<PacienteDTO> getListaPaciente() {
		return listaPaciente;
	}
	
	public void setListaPaciente(List<PacienteDTO> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	

}
