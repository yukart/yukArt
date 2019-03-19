package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnexionForm {
	
	@GetMapping("/")
	public String connexion() {
		return "views/connexion";
		
	}

}
