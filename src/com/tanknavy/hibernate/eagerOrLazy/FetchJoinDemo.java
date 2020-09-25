package com.tanknavy.hibernate.eagerOrLazy;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
			//Instructor tmpInstructor = new Instructor("Alex","Cheng","tanknavy@gmail.com"); //子表
			
			//InstructorDetail tmpInstructorDetail = 
			//new InstructorDetail("http://www.youtube.com/","Video Games");//父表
			
			// start a transaction
			session.beginTransaction();

			// Hibernate query with HQL
			
			int theId = 3;
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " //读取i全部栏位
					+ "JOIN FETCH i.courses " // 连带读取相关的courses
					+ "where i.id=:theInstructorId", Instructor.class); //i表where条件
			
			// set parameter on query
			query.setParameter("theInstructorId", theId); //HQL的参数设定
			
			// execute query and get instructor
			Instructor tmpInstructor = query.getSingleResult();//读取单个记录
			
			//Instructor tmpInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tmpInstructor); //Eager/Lazy
			//System.out.println("Courses: " + tmpInstructor.getCourses());
			
			//Course course1 = new Course("Java Lesson");
			//Course course2 = new Course("ETL Lesson");
			
			// associate the objects
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			//tmpInstructor.add(course1); //一对多
			//tmpInstructor.add(course2);
			
			// start a transaction
			//session.beginTransaction();
			
			// save the Java object
			//System.out.println("Saving the student objet...");
			//session.save(tmpInstructor); // CascadeType.ALL保存带有子表记录(foreign key)也会保存父表的记录
			//session.save(tmpInstructorDetail); //保存父表不会外键表
			//session.save(course1); session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("session is closed! \n");
			System.out.println("Courses: " + tmpInstructor.getCourses());
			System.out.println("Done!");
			
		} 
		finally { //无论成功与否都关掉factory
			session.close();
			factory.close();
		}
		
	}

}
