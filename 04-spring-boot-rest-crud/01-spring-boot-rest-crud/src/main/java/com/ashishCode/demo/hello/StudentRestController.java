package com.ashishCode.demo.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashishCode.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudent;

	@PostConstruct
	public void LoadData() {

		theStudent = new ArrayList<>();

		theStudent.add(new Student("Ashish", "Pal"));
		theStudent.add(new Student("Vinayak", "More"));
		theStudent.add(new Student("Shiwangee", "Singh"));

	}

	@GetMapping("/student")
	public List<Student> getStudent() {

		return theStudent;

	}

	@GetMapping("/student/{StudentId}")

	private Student getStudentID(@PathVariable int StudentId) {

		// check the StudentID is present
		if (StudentId >= theStudent.size() || StudentId < 0) {
			throw new StudentNotFoundException("Student id not found : " + StudentId);
		}

		return theStudent.get(StudentId);
	}

}
