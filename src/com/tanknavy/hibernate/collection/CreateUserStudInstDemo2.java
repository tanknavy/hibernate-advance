package com.tanknavy.hibernate.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.inheritance.Instructor2;
import com.tanknavy.hibernate.inheritance.Student2;

public class CreateUserStudInstDemo2 {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg7.xml")
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student2.class) //
				.addAnnotatedClass(Instructor2.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			Student2 student = new Student2("Obama", "Doe","spark@gmail.com","bigdata");
		
			Instructor2 instructor = new Instructor2("Donald", "Trump","spark@gmail.com",65000.00);
		
			
			//4.start a session
			session.beginTransaction();
			
			//5.save the object
			System.out.println("saving the student and instructor...");
			session.persist(student);
			session.persist(instructor);
			
			//6.commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally {
			//7.clean up code
			session.close();
			factory.close();
		}
		

	}

}
