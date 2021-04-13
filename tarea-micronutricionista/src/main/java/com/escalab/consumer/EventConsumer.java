package com.escalab.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.escalab.dto.ConsultaMsgDTO;

public class EventConsumer {
	
	@RabbitListener(queues="consulta.created")
	public void receive(ConsultaMsgDTO consultaMsgDTO) {
	    System.out.println("Nombre Paciente: "+consultaMsgDTO.getNombrePaciente());
	    System.out.println("Edad Paciente: "+consultaMsgDTO.getEdadPaciente());
	    System.out.println("Nombre Doctor:"+consultaMsgDTO.getDoctor());
	    System.out.println("Especialidad: "+consultaMsgDTO.getEspecialidad());
	    System.out.println("Fecha Consulta: "+consultaMsgDTO.getFechaConsulta());
	    System.out.println("Hora Consulta:"+ consultaMsgDTO.getHoraConsulta());
	}
}

