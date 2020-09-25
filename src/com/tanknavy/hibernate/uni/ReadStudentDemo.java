package com.tanknavy.hibernate.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory,�����ļ���srcͬ��������Ҫָ��
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try { // ��ѯ

			// use the session object to save Java object

			// create a Java object
			System.out.println("Createing new student object ...");
			Student tempStudent = new Student("DuoLaiMi", "Lin", "happy@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the Java object
			System.out.println("Saving the student objet...");
			session.save(tempStudent); // ����java����

			// commit transaction
			session.getTransaction().commit();

			// ��ȡ����retrieve from db, primary key
			System.out.println("saved student, generated id: " + tempStudent.getId());

			session = factory.getCurrentSession(); // д֮����Ҫ�½�session

			session.beginTransaction(); // CRUD��hibernate���涼��Ҫtransaction
			Student myStudent = session.get(Student.class, tempStudent.getId()); // ��ȡDB��¼��Java����
			System.out.println("Get complete: " + myStudent);
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally { // ���۳ɹ���񶼹ص�factory
			factory.close();
		}

	}

}
