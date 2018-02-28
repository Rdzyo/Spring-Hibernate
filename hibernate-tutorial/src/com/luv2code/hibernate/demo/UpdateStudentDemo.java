package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			// commit the transaction
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for students
			System.out.println("Update email for students");
			
			session.createQuery("update Student s set email='foo@gmail.com'  where s.id='3' OR s.id='4'")
							.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
