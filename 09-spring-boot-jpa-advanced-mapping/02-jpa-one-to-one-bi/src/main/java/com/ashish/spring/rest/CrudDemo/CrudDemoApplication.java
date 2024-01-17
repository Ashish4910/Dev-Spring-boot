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
//			delete(appDAO);

			// findInstructorDetailById(appDAO);

			InstructorDetailsDeleteById(appDAO);

		};
	}

	private void InstructorDetailsDeleteById(AppDAO appDAO) {

		int theId = 8;

		System.out.println("Deleting the instructorDetails where id =" + theId);
	appDAO.instructorDetailDeleteById(theId);
		
		System.out.println("Done !..");

	}

	private void findInstructorDetailById(AppDAO appDAO) {

		// retrive using instrutorDetail
		int theId = 2;
		InstructorDetail temp = appDAO.findInstructorDetailById(theId);
		// display the detail of instructor
		System.out.println(temp);
		System.out.println("Done !! ");
		System.out.println(temp.getInstructor());

	}

	private void delete(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting value stored in " + id);

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
