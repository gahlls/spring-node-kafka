package com.gahlls.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gahlls.example.producer.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserProducer userProducer;

	@PostMapping
	public void send(@RequestBody User user) {
		userProducer.send(user);
	}
}
