package com.ashishCode.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class demo2 {

	@GetMapping("/hello")

	public String sayHello() {
		return "Hello World!";
	}

}
