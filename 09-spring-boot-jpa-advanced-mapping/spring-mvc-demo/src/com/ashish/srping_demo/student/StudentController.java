package com.ashish.srping_demo.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showStudentForm(Model theModel) {

		// create the studnet object
		Student theStudent = new Student();

		// bind the student object to the model to send over to the model
		theModel.addAttribute("student", theStudent);
		// theModel.addAttribute("student", theStudent);

		return "student-form";

	}

	@RequestMapping("/processForm")
	public String confirmationPage(@ModelAttribute("student") Student theStudent) {

		System.out.println("Student  full_name :" + theStudent.getFirstName() +"" + theStudent.getLastName());
		return "confirmation-page";
	}
}
