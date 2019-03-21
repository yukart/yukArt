package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusiqueController {
	@GetMapping("/musique")
	public String film(Model model) {
		return "musique";
	}
}
