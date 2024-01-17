package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> { // lamda expression
			createStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numOfRowDeleted = studentDAO.deleteAll();
		System.out.println(numOfRowDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Delete the record of :" + studentId + "  in the table");

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id : primnary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		// change firstName to "Scooby"
		Student mystudent = studentDAO.findById(studentId);
		// update the student
		studentDAO.update(mystudent);
		// display the updated student
		System.out.println(mystudent);
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {

		// get the student
		List<Student> theStudent = studentDAO.findStudentByLastName("123");
		// display the Student

		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {

		List<Student> theStudent = studentDAO.findAll();

		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// create the object
		Student theStudent = new Student("ASA", "123", "as@gmail.com");
		// save the object
		studentDAO.save(theStudent);
		// display the id of the student
		int theid = theStudent.getId();
		System.out.println("Display the student :" + theid);
		// retrieve the student
		Student mystudent = studentDAO.findById(theid);
		// display the context
		System.out.println(mystudent);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ");
		Student tempStudent = new Student("Ashish", "Pal", "palashish@gmail.com");
		Student tempStudent1 = new Student("afd", "Pal", "palashish@gmail.com");
		Student tempStudent2 = new Student("eeee", "Pal", "palashish@gmail.com");
		// save the student object
		System.out.println("Saving the student ");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		// display id of the saved Student
		System.out.println("Saved Student GeneratedID" + tempStudent.getId());
	}

}
