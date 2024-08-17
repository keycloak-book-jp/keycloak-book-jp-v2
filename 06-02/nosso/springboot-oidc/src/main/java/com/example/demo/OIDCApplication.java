package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
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
	public String user(HttpServletRequest httpRequest) {
		return response(httpRequest);
	}

	@GetMapping("/admin-area")
	public String admin(HttpServletRequest httpRequest) {
		return response(httpRequest);
	}

	@GetMapping("/anonymous-area")
	public String anonymous(HttpServletRequest httpRequest) {
		return response(httpRequest);
	}

	private String response(HttpServletRequest httpRequest) {

		StringBuilder response = new StringBuilder();
		response.append("<h3>");
		response.append(httpRequest.getMethod());
		response.append(" ");
		response.append(httpRequest.getRequestURI());
		response.append("</h3>");

		response.append("access by anonymous");
		return response.toString();
	}
}
