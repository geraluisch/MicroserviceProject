package com.escalab.composer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.escalab.dto.MedicoDTO;
import com.escalab.dto.MedicoPacienteDTO;
import com.escalab.dto.PacienteDTO;

@Component
public class MedicoPacienteComposer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public MedicoPacienteDTO parserMedicoPaciente() {
		
		MedicoPacienteDTO medicoPacienteDTO = new MedicoPacienteDTO();
		
		ResponseEntity<PacienteDTO[]> pacienteResponseEntity = restTemplate.getForEntity("http://MICRO-PACIENTE/pacientes/", PacienteDTO[].class);
		List<PacienteDTO> pacienteList = Arrays.asList(pacienteResponseEntity.getBody());
		
		
		ResponseEntity<MedicoDTO[]> medicoResponseEntity = restTemplate.getForEntity("http://MICRO-NUTRICIONISTA/nutricionistas/", MedicoDTO[].class);
		List<MedicoDTO> medicoList = Arrays.asList(medicoResponseEntity.getBody());
		
		
		medicoPacienteDTO.setListaPaciente(pacienteList);
		medicoPacienteDTO.setListaMedico(medicoList);
		
		
		return medicoPacienteDTO;
	}

}
