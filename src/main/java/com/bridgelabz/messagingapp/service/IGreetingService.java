package com.bridgelabz.messagingapp.service;

import com.bridgelabz.messagingapp.model.Greeting;
import com.bridgelabz.messagingapp.model.User;

public interface IGreetingService {

	Greeting addGreeting(User user);

	Greeting getGreetingById(Long id);

}