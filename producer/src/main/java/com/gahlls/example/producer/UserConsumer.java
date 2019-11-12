package com.gahlls.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.gahlls.example.producer.model.User;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserConsumer {

	@Autowired
	private Gson gson;

	@KafkaListener(topics =  "user-topic-response", groupId="group-id-response")
	public void getTopics(String response) {
		User model = gson.fromJson(response, User.class);
		log.info("Response  " + model);
	}
}
