package com.escalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.composer.MedicoPacienteComposer;
import com.escalab.dto.MedicoPacienteDTO;


@RestController
@RequestMapping("/composer")
public class ComposerController {	
	
	@Autowired
	private MedicoPacienteComposer medicoPacienteComposer;
	
	@GetMapping("/medicoPaciente")
	public MedicoPacienteDTO getCompraUsuario(){		
		
		return medicoPacienteComposer.parserMedicoPaciente();
	}
	
	
}
