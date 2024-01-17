package com.springboot.demoSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String sayHello() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeader() {
		return "leaders";
	}

	@GetMapping("/systems")
	public String showSystem() {
		return "System";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
