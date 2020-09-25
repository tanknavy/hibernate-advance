package com.tanknavy.hibernate.collection;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.StudentSet;

public class GetStudentImagesSortedSetDemo {

	public static void main(String[] args) {

		// 1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg6.xml") // create-only
				// .addAnnotatedClass(Instructor.class)
				// .addAnnotatedClass(InstructorDetail.class)
				// .addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentSet.class) //
				.buildSessionFactory();

		// 2.create session
		Session session = factory.getCurrentSession();

		try {
			
			// 3.start a session
			session.beginTransaction();

			// 4.get the student id
			int theId = 1;
			System.out.println("get the student and images...");
			StudentSet student = session.get(StudentSet.class, theId);
			
			//5. print the student detail
			System.out.println("student details: " + student);
			
			//5.2 print the associated images
			System.out.println("the associated images: " + student.getImages());
			
			// 6.commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			// 7.clean up code
			session.close();
			factory.close();
		}

	}

}
