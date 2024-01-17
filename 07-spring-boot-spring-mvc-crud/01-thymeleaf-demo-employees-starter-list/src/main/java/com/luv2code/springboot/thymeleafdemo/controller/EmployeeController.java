package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployees;

	public EmployeeController(EmployeeService EmployeeService) {

		theEmployees = EmployeeService;
	}
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employee = theEmployees.findAll();
		// add to the spring model
		theModel.addAttribute("employees", employee);

		return "employee/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForadd(Model theModel) {
		// create the model attribut to bind the data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee/Employee-Form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeID") int theId, Model theModel) {
		// get the employee form server
		Employee theEmployee = theEmployees.findById(theId);

		// set Employee in the model
		theModel.addAttribute("employee", theEmployee);

		return "employee/Employee-Form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeID") int theID) {

		theEmployees.deleteById(theID);

		return "redirect:/employees/list";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		theEmployees.save(theEmployee);
		return "redirect:/employees/list";

	}
}
