package com.ashish.srping_demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/showForm")
	public String showPage() {
		return "helloWorld-form";
	}
	
	@RequestMapping("/processForm")
	public String  processForm(){
		return "helloWorld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request , Model model) {
		
		// get the value from the HTML form
		
		String name = request.getParameter("studentName");
		
		// convert that value to the Upper case 
		name.toUpperCase();
		
		//store the value in model 
		 model.addAttribute("message",name);
		// return the value the jap page 
		
		return "helloWorld";
	}
}
