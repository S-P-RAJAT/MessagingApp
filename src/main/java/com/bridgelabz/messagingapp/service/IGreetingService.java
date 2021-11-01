package com.bridgelabz.messagingapp.service;

import java.util.List;

import com.bridgelabz.messagingapp.model.Greeting;
import com.bridgelabz.messagingapp.model.User;

public interface IGreetingService {

	Greeting addGreeting(User user);

	Greeting getGreetingById(Long id);

	List<Greeting> getGreetingsList();

	Greeting editGreetingById(Long id, String message);

}