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
import com.escalab.model.DetalleHistorial;
import com.escalab.service.IDetalleHistorialService;

@RestController
@RequestMapping("/hitorialDetalle")
public class HistorialDetalleController {
	
	@Autowired
	private IDetalleHistorialService servicio;
	
	@GetMapping
	public ResponseEntity<List<DetalleHistorial>> listar() {
		List<DetalleHistorial> lista = servicio.listar();
		return new ResponseEntity<List<DetalleHistorial>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleHistorial> listarPorId(@PathVariable("id") Integer id) {
		DetalleHistorial obj = servicio.leerPorId(id);
		if(obj.getIdDetalleHistorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		return new ResponseEntity<DetalleHistorial>(obj, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody DetalleHistorial detalle) {
		@SuppressWarnings("unused")
		DetalleHistorial obj = servicio.registrar(detalle);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(detalle.getIdDetalleHistorial()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public  ResponseEntity<DetalleHistorial> modificar(@Valid @RequestBody DetalleHistorial detalle) {
		DetalleHistorial obj = servicio.modificar(detalle);
		return new ResponseEntity<DetalleHistorial>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		DetalleHistorial obj = servicio.leerPorId(id);
		if(obj.getIdDetalleHistorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	} 
	

}
