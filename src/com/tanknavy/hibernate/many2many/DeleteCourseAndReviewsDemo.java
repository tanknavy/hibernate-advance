package com.tanknavy.hibernate.many2many;

import java.util.List;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定，注意JDBC中schema连接
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg4.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			//Instructor tmpInstructor = new Instructor("Alex","Cheng","tanknavy@gmail.com"); //子表
			
			//InstructorDetail tmpInstructorDetail = 
			//new InstructorDetail("http://www.youtube.com/","Video Games");//父表
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//int theId = 14; //course id
			//Instructor tmpInstructor = session.get(Instructor.class, theId);
			//Course course = session.get(Course.class, theId);
			
			//System.out.println(course);
			//System.out.println(course.getReviews());
			
			//session.delete(course);
			
			
			int theId = 14; //reviewId
			Review tmpReview = session.get(Review.class, theId);
			session.delete(tmpReview);
			
			//Course course = new Course("BW Lesson");
			//Course course2 = new Course("React.js Lesson");
			//course.setInstructor(tmpInstructor);
			
			// associate the objects
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			//course.addReview(new Review("I love this course, thanks"));
			//course.addReview(new Review("I love this course, thanks"));
			//course.addReview(new Review("What a dumb, you're a idiot!"));
			
			
			// start a transaction
			//session.beginTransaction();
			
			// save the Java object
			System.out.println("Saving the student objet...");
			//session.save(tmpInstructor); // CascadeType.ALL保存带有子表记录(foreign key)也会保存父表的记录
			//session.save(tmpInstructorDetail); //保存父表不会外键表
			//session.save(course); //session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		finally { //无论成功与否都关掉factory
			session.close();
			factory.close();
		}
		
	}

}
