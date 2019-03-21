package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {
	@GetMapping("/film")
	public String film(Model model) {
		return "film";
	}
}
