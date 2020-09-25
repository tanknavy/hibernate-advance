package com.tanknavy.hibernate.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.inheritance.Instructor;
import com.tanknavy.hibernate.inheritance.Student;

public class CreateUserStudInstDemo {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg7.xml")
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class) //
				.addAnnotatedClass(Instructor.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			Student student = new Student("Obama", "Doe","spark@gmail.com","bigdata");
		
			Instructor instructor = new Instructor("Donald", "Trump","spark@gmail.com",65000.00);
		
			
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
