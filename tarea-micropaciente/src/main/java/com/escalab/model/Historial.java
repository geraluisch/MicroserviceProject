package com.escalab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistorial;
	
	@OneToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_historial_paciente"))
	private Paciente paciente;
	
	private LocalDateTime fechaRegistro;
	
    @Column(name = "info_enfermedades", length = 250, nullable = true)
	private Integer infoEnfermedades;
    
    @Column(name = "info_cirugias", length = 250, nullable = true)
	private Integer infoCirugias;
    
    @Column(name = "info_alergias", length = 250, nullable = true)
	private Integer infoAlergias;
    
    @Column(name = "info_habitos", length = 250, nullable = true)
	private Integer infoHabitos;

	public Integer getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getInfoEnfermedades() {
		return infoEnfermedades;
	}

	public void setInfoEnfermedades(Integer infoEnfermedades) {
		this.infoEnfermedades = infoEnfermedades;
	}

	public Integer getInfoCirugias() {
		return infoCirugias;
	}

	public void setInfoCirugias(Integer infoCirugias) {
		this.infoCirugias = infoCirugias;
	}

	public Integer getInfoAlergias() {
		return infoAlergias;
	}

	public void setInfoAlergias(Integer infoAlergias) {
		this.infoAlergias = infoAlergias;
	}

	public Integer getInfoHabitos() {
		return infoHabitos;
	}

	public void setInfoHabitos(Integer infoHabitos) {
		this.infoHabitos = infoHabitos;
	}
	
	

}
