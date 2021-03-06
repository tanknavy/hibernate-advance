package com.tanknavy.hibernate.uni;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定，注意JDBC中schema连接
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key/id(子表)
			int theId = 2;
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + theInstructor.toString());
			
			// delete the 子表级联父表
			if ( theInstructor != null) {
				
				System.out.println("delete the java objet...");
				session.delete(theInstructor); //CascadeType.ALL级联将删除detail表记录
				
			}
	
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		finally { //无论成功与否都关掉factory
			factory.close();
		}
		
	}

}
