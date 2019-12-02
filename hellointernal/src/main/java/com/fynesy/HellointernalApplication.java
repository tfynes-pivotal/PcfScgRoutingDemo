package com.fynesy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HellointernalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellointernalApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("hello internal");
		return "hello internal\n";
	}
	
	@RequestMapping("/foo")
	public String foo() {
		System.out.println("hello internal foo");
		return "hello internal foo\n";
	}
	
	

}
