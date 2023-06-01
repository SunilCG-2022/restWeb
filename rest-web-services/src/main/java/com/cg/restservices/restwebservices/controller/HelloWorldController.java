package com.cg.restservices.restwebservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "Hello World new";
	}
	
	@GetMapping(path="/helloBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Wold Bean");
	}
	
	
	@GetMapping(path="/helloName/{name}")
	public HelloWorldBean helloWorldVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello Wold ,%s",name));
	}

	@GetMapping("/hello-world-internationalized")
	public String InternationalizedMessage() {
		Locale locale = LocaleContextHolder.getLocale();
	return messageSource.getMessage("good.morning.message", null, "Default message", locale);
		
		//Good Morning to-
		//1.'nl':Dutch:-"Goedemorgen"
		//2.'fr':french:-"Bonjour"
		//3.'spa':Espanyol:-"buen dia"
	    //4.'jpn':Japneese:-"Ohayo"
	}
}
