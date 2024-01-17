package com.springboot.thymeleafdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hello {
	@GetMapping("/hello")
	public String sayHello(Model themodel) {

		themodel.addAttribute("theDate", new java.util.Date());
		return "HelloWorld";

	}

}
