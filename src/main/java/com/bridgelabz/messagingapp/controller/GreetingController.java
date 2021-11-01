package com.bridgelabz.messagingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.messagingapp.model.Greeting;
import com.bridgelabz.messagingapp.model.User;
import com.bridgelabz.messagingapp.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private IGreetingService greetingService;

	@RequestMapping(value = { "", "/", "/home" })
	public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}

	@GetMapping("/query")
	public Greeting greetingQuery(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/param/{name}")
	public Greeting greetingParam(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/post")
	public Greeting greeting(@RequestBody User user) {

		return new Greeting(counter.incrementAndGet(),
				String.format(template, user.getFirstName() + " " + user.getLastName()));
	}

	@PutMapping("put/{firstName}")
	public Greeting greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {

		return new Greeting(counter.incrementAndGet(), String.format(template, firstName + " " + lastName));
	}

	@GetMapping("/display")
	public Greeting greeting() {
		Long id = (long) 1;
		return greetingService.getGreetingById(id);
	}
}
