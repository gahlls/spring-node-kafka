package com.gahlls.example.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.gahlls.example.producer.model.User;

@Component
public class UserProducer {

	@Value("${user.topic}")
	private String userTopic;

	@Autowired 
	private KafkaTemplate kafkaTemplate;

	public void send(final User user) {
		final String mensageKey = UUID.randomUUID().toString();
		kafkaTemplate.send(userTopic, mensageKey, user);
	}
}
