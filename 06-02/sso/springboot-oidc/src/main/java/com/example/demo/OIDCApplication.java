package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OIDCApplication {

	public static void main(String[] args) {
		SpringApplication.run(OIDCApplication.class, args);
	}

	@GetMapping("/user-area")
	public String user(HttpServletRequest httpRequest, Authentication authentication) {
		return response(httpRequest, authentication);
	}

	@GetMapping("/admin-area")
	public String admin(HttpServletRequest httpRequest, Authentication authentication) {
		return response(httpRequest, authentication);
	}

	@GetMapping("/anonymous-area")
	public String anonymous(HttpServletRequest httpRequest, Authentication authentication) {
		return response(httpRequest, authentication);
	}

	private String response(HttpServletRequest httpRequest, Authentication authentication) {

		StringBuilder response = new StringBuilder();
		response.append("<h3>");
		response.append(httpRequest.getMethod());
		response.append(" ");
		response.append(httpRequest.getRequestURI());
		response.append("</h3>");
		response.append("access by ");

		if (authentication != null) {
			DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();

			if (oidcUser != null) {
				response.append("<ul>");
				response.append("<li>PREFERRED_USERNAME : ");
				response.append(oidcUser.getPreferredUsername());
				response.append("<li>EMAIL : ");
				response.append(oidcUser.getEmail());
				response.append("<li>GIVEN_NAME : ");
				response.append(oidcUser.getGivenName());
				response.append("<li>FAMILY_NAME : ");
				response.append(oidcUser.getFamilyName());
				response.append("</ul>");
			}

		} else {
			response.append("anonymous");
		}

		return response.toString();

	}
}
