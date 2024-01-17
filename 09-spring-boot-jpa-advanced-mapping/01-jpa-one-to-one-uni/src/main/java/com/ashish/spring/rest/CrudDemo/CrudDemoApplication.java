package com.ashish.spring.rest.CrudDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ashish.spring.rest.CrudDemo.dao.AppDAO;
import com.ashish.spring.rest.CrudDemo.entity.Instructor;
import com.ashish.spring.rest.CrudDemo.entity.InstructorDetail;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			/* createInstructor(appDAO); */
//			findInstructor(appDAO);
			delete(appDAO);
		};
	}

	private void delete(AppDAO appDAO) {

		int id = 1;

		
		System.out.println("Deleting value stored in "+ id);
		
		
		appDAO.delete(id);

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 4;

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*
		 * // create the Instructor Object Instructor tempInstructor = new
		 * Instructor("Shiwangee", "Singh", "singh@gmail.com");
		 * 
		 * // create the InstructorDetails Object InstructorDetail instructorDetail =
		 * new InstructorDetail("youtube/shiwangee", "Shiwangee!!");
		 */

		// create the Instructor Object
		Instructor tempInstructor = new Instructor("Ashish", "Pal", "pal@gmail.com");

		// create the InstructorDetails Object
		InstructorDetail instructorDetail = new InstructorDetail("youtube/shi", "Ashish!!");

		// associate the object
		tempInstructor.setInstructorDetail(instructorDetail);

		System.out.println("saving Instructor : " + tempInstructor);

		appDAO.save(tempInstructor);
		System.out.println("Done");

	}
}
