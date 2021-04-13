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
import com.escalab.model.DetalleConsulta;
import com.escalab.service.IDetalleConsultaService;


@RestController
@RequestMapping("/detalleConsulta")
public class DetalleConsultaController {
	
	@Autowired
	private IDetalleConsultaService servicio;
	
	@GetMapping
	public ResponseEntity<List<DetalleConsulta>> listar(){
		List<DetalleConsulta> lista = servicio.listar();
		return new ResponseEntity<List<DetalleConsulta>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleConsulta> listaPorId(@PathVariable("id") Integer id){
		DetalleConsulta obj = servicio.leerPorId(id);
		if(obj.getIdDetalle() == null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<DetalleConsulta>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody DetalleConsulta detalle){
		DetalleConsulta obj = servicio.registrar(detalle);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdDetalle()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<DetalleConsulta> modificar(@Valid @RequestBody DetalleConsulta detalle){
		DetalleConsulta obj = servicio.modificar(detalle);
		return new ResponseEntity<DetalleConsulta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		DetalleConsulta obj = servicio.leerPorId(id);
		if(obj.getIdDetalle() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
