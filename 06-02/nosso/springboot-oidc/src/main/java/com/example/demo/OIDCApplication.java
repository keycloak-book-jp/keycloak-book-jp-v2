package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OIDCApplication {

	public static void main(String[] args) {
		SpringApplication.run(OIDCApplication.class, args);
	}

	@GetMapping("/user-area")
	public String user() {
		return response();
	}

	@GetMapping("/admin-area")
	public String admin() {
		return response();
	}

	@GetMapping("/anonymous-area")
	public String anonymous() {
		return response();
	}

	private String response() {
		return "access by anonymous";
	}
}
