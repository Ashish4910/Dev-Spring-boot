package com.ashish.spring.rest.CrudDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ashish.spring.rest.CrudDemo.dao.AppDAO;
import com.ashish.spring.rest.CrudDemo.entity.Course;
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

			// InstructorDetailsDeleteById(appDAO);

			// createInstructorWithCourse(appDAO);

			// fetchinstructorbyID(appDAO);

			// getCourseByInstructorId(appDAO);

			// findInstructorWithCourseJoinFetch(appDAO);
			// updateInstructor(appDAO);

			// findCourseById(appDAO);

			// updateCourseByid(appDAO);

			// deleteInstructotById(appDAO);

			deleteCourseById(appDAO);

		};
	}

	private void deleteCourseById(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println(tempCourse);
		System.out.println("Deleting the Course where id =" + theId);

		appDAO.deleteCourseById(theId);
	}

	private void deleteInstructotById(AppDAO appDAO) {

		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(" Deleting the Instructor where id = " + theId);
		appDAO.deleteInstructor(theId);

		System.out.println(" Done ");
	}

	private void updateCourseByid(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("updating the course where id = " + theId);

		tempCourse.setTitle("prashik javascript course !! ");
		appDAO.update(tempCourse);
		System.out.println("Done !!");
	}

	private void findCourseById(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println(tempCourse);

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the Instructor with id
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		tempInstructor.setLastName("more");

		System.out.println("Display the lastName " + tempInstructor);

		appDAO.update(tempInstructor);

	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Showing only instructor value only " + tempInstructor);

		System.out.println("Course details only " + tempInstructor.getCourse());
		System.out.println("Done !! ");

	}

	private void getCourseByInstructorId(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor details " + tempInstructor);

		List<Course> course = appDAO.findCourseByInstructorId(theId);

		tempInstructor.setCourse(course);

		System.out.println(tempInstructor.getCourse());
		System.out.println("Done !!");

	}

	private void fetchinstructorbyID(AppDAO appDAO) {

		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(" Showing the instructor details  " + tempInstructor);
		System.out.println(tempInstructor.getCourse());
		System.out.println("Done !");

	}

	private void createInstructorWithCourse(AppDAO appDAO) {

		// create the Instructor
		Instructor instructor = new Instructor("Ashish", "pal", "pal@gmail.com");

		// create the InstructorDetail
		InstructorDetail instructorDetail = new InstructorDetail("http://youtube", "love trading");

		instructor.setInstructorDetail(instructorDetail);

		// create some course

		Course tempCourse1 = new Course("Air Guiter");
		Course tempCourse2 = new Course("Wake Up shanduu shiwiii");

		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		System.out.println("Saving the Instructor " + instructor);
		appDAO.save(instructor);
		System.out.println("Done");

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
