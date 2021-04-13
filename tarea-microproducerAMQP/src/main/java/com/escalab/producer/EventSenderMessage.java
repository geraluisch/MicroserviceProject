package com.escalab.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.escalab.model.ConsultaMsgDTO;

public class EventSenderMessage {
	
	@Autowired
	private AmqpTemplate rabbitTemp;
	
	@Autowired
	private TopicExchange topicExchange;
	
	public EventSenderMessage() {}
	
	
	public void sendMessage(ConsultaMsgDTO consultaMsgDTO) {
		rabbitTemp.convertAndSend(topicExchange.getName(),"consulta.created", consultaMsgDTO);
	}
}
