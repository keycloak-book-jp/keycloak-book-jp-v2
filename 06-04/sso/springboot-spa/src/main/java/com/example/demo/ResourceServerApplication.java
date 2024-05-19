package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}

	@RequestMapping(value = "/spa-resource-server/user", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public String user(HttpServletRequest httpRequest, JwtAuthenticationToken jwt) {
		String sub = jwt.getToken().getClaim("sub");

		StringBuffer response = new StringBuffer();
		response.append("{");
		response.append("  \"method\" : \"" + httpRequest.getMethod() + "\", ");
		response.append("  \"userId\" : \"" + sub + "\" ");
		response.append("}");

		return response.toString();
	}

}
