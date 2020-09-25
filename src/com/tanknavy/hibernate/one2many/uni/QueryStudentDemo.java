package com.tanknavy.hibernate.one2many.uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();
			
			// HQL Query, 语句使用Java的class和field，不是DB里面的table和column
			// 支持
			//List<Student> students = session.createQuery("from Student").getResultList();
			List<Student> students = session.createQuery("from Student s where s.firstName='Happy'").getResultList();
			//List<Student> students = session.createQuery(
			//	"from Student s where s.lastName='Qian' or s.firstName='Win'").getResultList();
			//List<Student> students = session.createQuery(
			//		"from Student s where s.email like '%126%'").getResultList();
			
			
			// display query result使用factor方法重构
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally { //无论成功与否都关掉factory
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> students) {
		for (Student s: students) {
			System.out.println(s);
		}
	}

}
