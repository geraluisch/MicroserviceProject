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
import com.escalab.model.Nutricionista;
import com.escalab.service.INutricionistaService;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {
	
	@Autowired
	private INutricionistaService servicio;
	
	@GetMapping
	public ResponseEntity<List<Nutricionista>> listar() {
		List<Nutricionista> lista = servicio.listar();
		return new ResponseEntity<List<Nutricionista>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nutricionista> listarPorId(@PathVariable("id") Integer id) {
		Nutricionista obj = servicio.leerPorId(id);
		if(obj.getIdNutricionista() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		return new ResponseEntity<Nutricionista>(obj, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Nutricionista nutricionista) {
		@SuppressWarnings("unused")
		Nutricionista obj = servicio.registrar(nutricionista);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(nutricionista.getIdNutricionista()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public  ResponseEntity<Nutricionista> modificar(@Valid @RequestBody Nutricionista nutricionista) {
		Nutricionista obj = servicio.modificar(nutricionista);
		return new ResponseEntity<Nutricionista>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Nutricionista obj = servicio.leerPorId(id);
		if(obj.getIdNutricionista() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	
	

}
