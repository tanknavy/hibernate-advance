package com.tanknavy.hibernate.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Address;
import com.tanknavy.hibernate.entity.StudentEmbed;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		//1.create session factory
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg8.xml") //6:create-only
				//.addAnnotatedClass(Instructor.class)
				//.addAnnotatedClass(InstructorDetail.class)
				//.addAnnotatedClass(Course.class)
				.addAnnotatedClass(StudentEmbed.class) //
				.buildSessionFactory();
		
		//2.create session
		Session session = factory.getCurrentSession();
		
		try {
			//3.create the object
			StudentEmbed tempStudent = new StudentEmbed("Apple", "Lee","spark@gmail.com");
			
			//3.2.create the address object to aggregate into student class
			Address address = new Address("Amar Ave.", "West Convina", "91789");
			tempStudent.setHomeAddress(address);
			tempStudent.setBillingAddress(address);
			
			//4.start a session
			session.beginTransaction();
			
			//5.save the object
			System.out.println("saving the student2 and images...");
			session.persist(tempStudent); //持久化
			
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
