package com.carbon.apicarbon;


import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ApiCarbonApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ApiCarbonApplication.class, args);
	}

	
	/**
	 * client call localhost:9999
	 * If not authenticated, ask for authorization (OAuth2)
	 * If success, send user back to the client (JSESSIONID is set for proof)
	 * @param httpServletResponse
	 */
	@GetMapping("/")
	public void method(HttpServletResponse httpServletResponse, @AuthenticationPrincipal OAuth2User principal) {

		
		if ( principal != null ) {
			System.out.println(principal.getName());
			System.out.println(principal.getAttributes());
	
			principal.getAttributes().entrySet().stream().forEach(attribute -> System.out.println(attribute.getKey() + " : " + attribute.getValue() ));
		} else {
			System.out.println("NO OAUTH2 USER AUTHENTICATED");
		}

		httpServletResponse.setHeader("Location", "http://localhost:3000");
		httpServletResponse.setStatus(302);
	}

	@GetMapping("/test")
	public ResponseEntity<?> methodTest(@AuthenticationPrincipal OAuth2User principal) {

		System.out.println(principal.getName());
		System.out.println(principal.getAttributes());

		principal.getAttributes().entrySet().stream().forEach(attribute -> System.out.println(attribute.getKey() + " : " + attribute.getValue() ));
		return ResponseEntity.ok().body("salut");
	}



}
