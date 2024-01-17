package com.ashish.srping_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloworld_form {

	@RequestMapping("/")
	public String helloWorld() {
		return "main-menu";
	}

}
