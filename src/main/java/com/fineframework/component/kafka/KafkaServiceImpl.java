package com.fineframework.component.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaServiceImpl implements KafkaService {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	public void send() {
		kafkaTemplate.send("springkafka", "hello world");
	}

}
