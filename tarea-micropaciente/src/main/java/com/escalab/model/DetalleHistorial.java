package com.escalab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historial_detalle")
public class DetalleHistorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdDetalleHistorial;
	
	@ManyToOne
	@JoinColumn(name = "id_historial", nullable = false, foreignKey = @ForeignKey(name = "FK_historial_detalle"))
	private Historial historial;
	
	private LocalDateTime fecha;
	
	@Column(name = "edad", nullable = false)
	private Integer edad;
	
	@Column(name = "peso", nullable = false)
	private Integer peso;
	
	@Column(name = "altura", nullable = false)
	private Integer altura;
	
	@Column(name = "medidas", nullable = false)
	private Integer medidas;
	
	@Column(name = "presion", nullable = false)
	private Integer presion;

	public Integer getIdDetalleHistorial() {
		return IdDetalleHistorial;
	}

	public void setIdDetalleHistorial(Integer idDetalleHistorial) {
		IdDetalleHistorial = idDetalleHistorial;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getMedidas() {
		return medidas;
	}

	public void setMedidas(Integer medidas) {
		this.medidas = medidas;
	}

	public Integer getPresion() {
		return presion;
	}

	public void setPresion(Integer presion) {
		this.presion = presion;
	}
}
