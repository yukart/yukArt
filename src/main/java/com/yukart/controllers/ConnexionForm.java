package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConnexionForm {

	@GetMapping("/login")
	@ResponseBody
	public String connexion() {
		return "views/connexion";

	}

}
