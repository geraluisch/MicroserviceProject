package com.escalab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.escalab.model.Especialidad;
import com.escalab.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
	
	@Autowired
	private IEspecialidadService servicio;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> listar() {
		List<Especialidad> lista = servicio.listar();
		return new ResponseEntity<List<Especialidad>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id) {
		Especialidad obj = servicio.leerPorId(id);
		if(obj. getIdEspecialidad() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		return new ResponseEntity<Especialidad>(obj, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Especialidad especialidad) {
		@SuppressWarnings("unused")
		Especialidad obj = servicio.registrar(especialidad);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(especialidad.getIdEspecialidad()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public  ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad especialidad) {
		Especialidad obj = servicio.modificar(especialidad);
		return new ResponseEntity<Especialidad>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Especialidad obj = servicio.leerPorId(id);
		if(obj.getIdEspecialidad() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	

}
