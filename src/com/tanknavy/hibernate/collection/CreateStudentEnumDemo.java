package com.tanknavy.hibernate.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Status;
import com.tanknavy.hibernate.entity.StudentEnum;

public class CreateStudentEnumDemo {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg7.xml")
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentEnum.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			StudentEnum s1 = new StudentEnum("Obama", "Doe","spark@gmail.com");
			s1.setStatus(Status.ACTIVE);
			StudentEnum s2 = new StudentEnum("Donald", "Trump","spark@gmail.com");
			s2.setStatus(Status.INACTIVE);
			
			//4.start a session
			session.beginTransaction();
			
			//5.save the object
			System.out.println("saving the student2 and images...");
			session.persist(s1);
			session.persist(s2);
			
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
