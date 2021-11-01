package com.bridgelabz.messagingapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.messagingapp.model.Greeting;
import com.bridgelabz.messagingapp.model.User;
import com.bridgelabz.messagingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(Long id) {
		return greetingRepository.findById(id).get();
	}
	
	@Override
	public List<Greeting> getGreetingsList() {
		return greetingRepository.findAll();
	}
	
	@Override
	public Greeting editGreetingById(Long id, String message) {
		Greeting greeting = getGreetingById(id);
		message = String.format(template, (message.isEmpty()) ? "World" : message);
		greeting.setMessage(message);
		return greetingRepository.save(greeting);
	}
}