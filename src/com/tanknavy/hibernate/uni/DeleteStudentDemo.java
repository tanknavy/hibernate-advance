package com.tanknavy.hibernate.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory,�����ļ���srcͬ��������Ҫָ��
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 13;

			// start a transaction
			session.beginTransaction(); // CRUD��hibernate���涼��Ҫtransaction
			Student myStudent = session.get(Student.class, studentId); // ��ȡDB��¼��Java����
			System.out.println("Before update: " + myStudent);
			
			// ɾ��һ����¼
			session.delete(myStudent);; // ɾ��һ����¼(java object)
			session.getTransaction().commit(); // �ύ����
			// �����������
			session = factory.getCurrentSession();
			session.beginTransaction(); // CRUD��hibernate���涼��Ҫtransaction
			myStudent = session.get(Student.class, studentId); // ��ȡDB��¼��Java����
			System.out.println("After update: " + myStudent);
			
			// ���¶�����¼
			//session = factory.getCurrentSession();
			//session.beginTransaction();//û��commit�Ͳ���begin
			session.createQuery("delete from Student where email like '%fb.com%'").executeUpdate();
			session.getTransaction().commit(); // �ύ����
	

			System.out.println("Done!");

		} finally { // ���۳ɹ���񶼹ص�factory
			factory.close();
		}

	}

}
