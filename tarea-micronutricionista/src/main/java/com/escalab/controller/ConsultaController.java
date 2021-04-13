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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Consulta;
import com.escalab.model.Paciente;
import com.escalab.service.IConsultaService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private IConsultaService servicio;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar(){
		 List<Consulta> lista = servicio.listar();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id){
		Consulta obj = servicio.leerPorId(id);
		if(obj.getIdConsulta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK); 
	}	

	@HystrixCommand(fallbackMethod = "fallbackMethod")
	@GetMapping("/paciente/{id}")
	public Paciente getPaciente(@PathVariable("id") Integer id) {
		
		Paciente paciente = restTemplate.getForObject("http://MICRO-PACIENTE/pacientes/"+id, Paciente.class);
		return paciente;
	}	
	
	private Paciente fallbackMethod(String id) {
		System.out.println("*************************FALLE LLAMANDO MENTODO FALLBACK*********************************");
		Paciente paciente = restTemplate.getForObject("http://MICRO-PACIENTE/pacientes/"+id, Paciente.class);
		return paciente;		
	}	
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Consulta consulta) {
		Consulta obj = servicio.registrar(consulta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}	
	
	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta consulta) {
		Consulta obj = servicio.modificar(consulta);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Consulta obj = servicio.leerPorId(id);
		if(obj.getIdConsulta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
