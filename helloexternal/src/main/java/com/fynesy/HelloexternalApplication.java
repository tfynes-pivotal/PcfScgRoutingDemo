package com.fynesy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloexternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloexternalApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("hello external");
		return "hello external\n";
	}
	
	@RequestMapping("/foo")
	public String foo() {
		System.out.println("hello external foo");
		return "hello external foo\n";
	}
	

	@RequestMapping("/search")
	public String search() {
		System.out.println("hello external search");
		return "hello external search\n";
	}
	
	@RequestMapping("/search/foo")
	public String searchfoo() {
		System.out.println("hello external search foo");
		return "hello external search foo\n";
	}
}
