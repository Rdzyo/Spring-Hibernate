package com.luv2code.hibernate.demo; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			// create a course
			Course tempCourse = new Course("Pacman - How to score million points");
			// save the course... and leverage cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			// create the students
			Student tempStudent1 = new Student("Albert","King","albert@luv2code.com");
			Student tempStudent2 = new Student("Rubi","Szubert","rubi@luv2code.com");
			Student tempStudent3 = new Student("Stew","Cold","stew@luv2code.com");
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			// save the students
			System.out.println("\nSaving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saved students: " + tempCourse.getStudents());
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
