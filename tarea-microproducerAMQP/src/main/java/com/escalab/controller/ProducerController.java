package com.escalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.model.ConsultaMsgDTO;
import com.escalab.producer.EventSenderMessage;

@RestController
public class ProducerController {
	
	@Autowired
	EventSenderMessage eventSenderMessage;
	
	@GetMapping("/send")
	public String sendMessage()
	{
		ConsultaMsgDTO consultaMsgDTO = new ConsultaMsgDTO();
		consultaMsgDTO.setNombrePaciente("Luis Chourio");
		consultaMsgDTO.setEdadPaciente("34");
		consultaMsgDTO.setDoctor("Geraldine Chourio");
		consultaMsgDTO.setEspecialidad("Nutricionista");
		consultaMsgDTO.setFechaConsulta("2021-05-03");
		consultaMsgDTO.setHoraConsulta("13:00");
		eventSenderMessage.sendMessage(consultaMsgDTO);
		
		return "ok";
	}

}
