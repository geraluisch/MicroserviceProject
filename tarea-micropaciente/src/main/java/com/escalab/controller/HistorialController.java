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
import com.escalab.model.Historial;
import com.escalab.service.IHistorialService;


@RestController
@RequestMapping("/historial")
public class HistorialController {
	
	@Autowired
	private IHistorialService servicio;
	
	@GetMapping
	public ResponseEntity<List<Historial>> listar() {
		List<Historial> lista = servicio.listar();
		return new ResponseEntity<List<Historial>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Historial> listarPorId(@PathVariable("id") Integer id) {
		Historial obj = servicio.leerPorId(id);
		if(obj.getIdHistorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		return new ResponseEntity<Historial>(obj, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Historial historial) {
		@SuppressWarnings("unused")
		Historial obj = servicio.registrar(historial);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(historial.getIdHistorial()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public  ResponseEntity<Historial> modificar(@Valid @RequestBody Historial historial) {
		Historial obj = servicio.modificar(historial);
		return new ResponseEntity<Historial>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Historial obj = servicio.leerPorId(id);
		if(obj.getIdHistorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	

}
