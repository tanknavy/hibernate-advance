package com.tanknavy.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory,�����ļ���srcͬ��������Ҫָ��
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// create several Java object �������
			System.out.println("Createing new student object ...");
			Student tempStudent1 = new Student("Offer", "Win", "Merry@fb.com");
			Student tempStudent2 = new Student("Cash", "Win", "Merry@126.com");
			Student tempStudent3 = new Student("Win", "", "Fortune@apple.com");

			// start a transaction��ʼһ������
			session.beginTransaction();

			// save the Java object ����������
			System.out.println("Saving the student objet...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction �ύ����
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally { // ���۳ɹ���񶼹ص�factory
			factory.close();
		}

	}

}
