package com.bridgelabz.messagingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.messagingapp.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
