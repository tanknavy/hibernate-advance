package com.tanknavy.hibernate.eagerOrLazy;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定，注意JDBC中schema连接
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg3.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tmpInstructor = new Instructor("David","Cheng","tanknavy@gmail.com"); //子表
			
			InstructorDetail tmpInstructorDetail = 
					new InstructorDetail("http://www.youtube.com/","Video Games");//父表
			
			//Course course = new Course("Java Lesson");
			
			// associate the objects
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the Java object
			System.out.println("Saving the student objet...");
			session.save(tmpInstructor); // CascadeType.ALL保存带有子表记录(foreign key)也会保存父表的记录
			//session.save(tmpInstructorDetail); //保存父表不会外键表
			
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
