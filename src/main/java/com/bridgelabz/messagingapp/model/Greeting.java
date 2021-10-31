package com.bridgelabz.messagingapp.model;

public class Greeting {
	private long GreetingId;
	private String name;

	public Greeting(long incrementAndGet, String name) {
		setGreetingId(incrementAndGet);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getGreetingId() {
		return GreetingId;
	}

	public void setGreetingId(long greetingId) {
		GreetingId = greetingId;
	}

}