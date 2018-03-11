package com.luv2code.hibernate.demo;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			// get the instructor from db
			int theId = 1;
			Query<Instructor> query = session.createQuery("Select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id=:theInstructorId", Instructor.class);
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("luv2code: Instructor" + tempInstructor);
			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("\nThe session is now closed\n");
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			System.out.println("luv2code: Done!");
		} finally {
			
			// add clean up code
			factory.close();
		}
	}

}
