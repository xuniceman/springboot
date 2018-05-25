package com.fineframework.component.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

	//@KafkaListener(topics= {"springkafka"})
	public void consumer(String message)
	{
		System.out.println(message+"========================");
	}
}
