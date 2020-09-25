package com.tanknavy.hibernate.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.StudentMap;

public class GetStudentImagesSortedMapDemo {

	public static void main(String[] args) {

		// 1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg6.xml") // create-only
				// .addAnnotatedClass(Instructor.class)
				// .addAnnotatedClass(InstructorDetail.class)
				// .addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentMap.class) //
				.buildSessionFactory();

		// 2.create session
		Session session = factory.getCurrentSession();

		try {
			
			// 3.start a session
			session.beginTransaction();

			// 4.get the student id
			int theId = 4;
			System.out.println("get the student and images...");
			StudentMap student = session.get(StudentMap.class, theId);
			
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
