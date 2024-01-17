package com.practice2308.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.practice2308.demo.dao.StudentDAO;
import com.practice2308.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO theStudent) {
		return runner -> {
			createStudent(theStudent);
		};

	}

	private void createStudent(StudentDAO theStudent) {

		// create the student object
		Student tempStudent = new Student("palashish@gmail.com", "123");

		// save the student object

		System.out.println(" save the student object ");
		theStudent.ashish(tempStudent);
		
		System.out.println("get the id"+tempStudent.getEmail()+tempStudent.getId());
		
	}

}
