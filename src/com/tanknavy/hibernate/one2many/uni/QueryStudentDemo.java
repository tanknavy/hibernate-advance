package com.tanknavy.hibernate.one2many.uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory,�����ļ���srcͬ��������Ҫָ��
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();
			
			// HQL Query, ���ʹ��Java��class��field������DB�����table��column
			// ֧��
			//List<Student> students = session.createQuery("from Student").getResultList();
			List<Student> students = session.createQuery("from Student s where s.firstName='Happy'").getResultList();
			//List<Student> students = session.createQuery(
			//	"from Student s where s.lastName='Qian' or s.firstName='Win'").getResultList();
			//List<Student> students = session.createQuery(
			//		"from Student s where s.email like '%126%'").getResultList();
			
			
			// display query resultʹ��factor�����ع�
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally { //���۳ɹ���񶼹ص�factory
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> students) {
		for (Student s: students) {
			System.out.println(s);
		}
	}

}
