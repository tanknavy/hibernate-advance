package com.tanknavy.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory,�����ļ���srcͬ��������Ҫָ��
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 6;

			// start a transaction
			session.beginTransaction(); // CRUD��hibernate���涼��Ҫtransaction
			Student myStudent = session.get(Student.class, studentId); // ��ȡDB��¼��Java����
			System.out.println("Before update: " + myStudent);
			
			// ����һ����¼
			myStudent.setFirstName("CoCO"); // һ����¼һ����λֱ��ʹ��java��set����
			session.getTransaction().commit(); // �ύ����
			// �����������
			session = factory.getCurrentSession();
			session.beginTransaction(); // CRUD��hibernate���涼��Ҫtransaction
			myStudent = session.get(Student.class, studentId); // ��ȡDB��¼��Java����
			System.out.println("After update: " + myStudent);
			
			
			// ���¶�����¼
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='cheng_alex@LA.com' where email like '%126%'").executeUpdate();
			session.getTransaction().commit(); // �ύ����
	

			System.out.println("Done!");

		} finally { // ���۳ɹ���񶼹ص�factory
			factory.close();
		}

	}

}
