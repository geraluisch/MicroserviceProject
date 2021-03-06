package com.escalab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Paciente;
import com.escalab.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService servicio;
	
	@Value("${server.port}")
	private String puerto;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> lista = servicio.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) {
		Paciente obj = servicio.leerPorId(id);
		if(obj.getIdPaciente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		obj.setPuerto(puerto);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente paciente) {
		@SuppressWarnings("unused")
		Paciente obj = servicio.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public  ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) {
		Paciente obj = servicio.modificar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Paciente obj = servicio.leerPorId(id);
		if(obj.getIdPaciente() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 

}
