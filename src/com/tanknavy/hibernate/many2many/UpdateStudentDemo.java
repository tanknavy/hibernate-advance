package com.tanknavy.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory,配置文件和src同级，否则要指定
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 6;

			// start a transaction
			session.beginTransaction(); // CRUD在hibernate里面都需要transaction
			Student myStudent = session.get(Student.class, studentId); // 读取DB记录到Java对象
			System.out.println("Before update: " + myStudent);
			
			// 更新一条记录
			myStudent.setFirstName("CoCO"); // 一条记录一个栏位直接使用java的set方法
			session.getTransaction().commit(); // 提交更新
			// 检查这条更新
			session = factory.getCurrentSession();
			session.beginTransaction(); // CRUD在hibernate里面都需要transaction
			myStudent = session.get(Student.class, studentId); // 读取DB记录到Java对象
			System.out.println("After update: " + myStudent);
			
			
			// 更新多条记录
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='cheng_alex@LA.com' where email like '%126%'").executeUpdate();
			session.getTransaction().commit(); // 提交更新
	

			System.out.println("Done!");

		} finally { // 无论成功与否都关掉factory
			factory.close();
		}

	}

}
