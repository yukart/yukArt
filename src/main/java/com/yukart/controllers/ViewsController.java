package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {

	@GetMapping("/")
	public String home(Model model) {
		return "views/index";
	}

	@GetMapping("/film")
	public String film(Model model) {
		return "views/film";
	}

	@GetMapping("/série")
	public String serie(Model model) {
		return "views/serie";
	}

	@GetMapping("/musique")
	public String musique(Model model) {
		return "views/musique";
	}

	@GetMapping("/compte")
	public String compte(Model model) {
		return "views/compte";
	}

}
