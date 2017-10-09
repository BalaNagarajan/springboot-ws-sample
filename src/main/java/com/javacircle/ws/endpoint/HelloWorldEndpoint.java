package com.javacircle.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javacircle.helloword.types.Greeting;
import com.javacircle.helloword.types.ObjectFactory;
import com.javacircle.helloword.types.Person;

@Endpoint
public class HelloWorldEndpoint {

	private static final String NAMESPACE_URI = "http://javacircle.com/types/helloworld";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "person")
	@ResponsePayload
	public Greeting sayHello(@RequestPayload Person request) {

		String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";
		System.out.println("------------Greeting-----------" + greeting);
		Greeting response = null;
		ObjectFactory factory = new ObjectFactory();
		response = factory.createGreeting();
		response.setGreeting(greeting);

		return response;

	}

}
