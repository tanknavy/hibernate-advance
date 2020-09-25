package com.tanknavy.hibernate.collection;

import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.StudentMap;

public class CreateStudentImagesMapDemo {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg7.xml")
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentMap.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			StudentMap tempStudent = new StudentMap("Scala", "success","spark@gmail.com");
			Map<String,String> theImages = tempStudent.getImages();
			
			theImages.put("azusa.jpg", "photo 1");
			theImages.put("hebei.jpg","photo 2");
			theImages.put("chucai.jpg", "photo 3");
			theImages.put("fuji.jpg","photo 4");
			theImages.put("azusa.jpg","photo 5");
			
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
