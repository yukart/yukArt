package com.yukart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SerieController {
	@GetMapping("/serie")
	public String film(Model model) {
		return "serie";
	}
}
