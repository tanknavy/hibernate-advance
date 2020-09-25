package com.tanknavy.hibernate.collection;import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.StudentSet;

public class CreateStudentImagesSetDemo {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentSet.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			StudentSet tempStudent = new StudentSet("Spark", "success","spark@gmail.com");
			Set<String> theImages = tempStudent.getImages();
			
			theImages.add("azusa.jpg");
			theImages.add("hebei.jpg");
			theImages.add("chucai.jpg");
			theImages.add("fuji.jpg");
			theImages.add("azusa.jpg");
			
			//4.start a session
			session.beginTransaction();
			
			//5.save the object
			System.out.println("saving the student2 and images...");
			session.persist(tempStudent);
			
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
