package com.tanknavy.hibernate.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory,配置文件和src同级，否则要指定
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try { // 查询

			// use the session object to save Java object

			// create a Java object
			System.out.println("Createing new student object ...");
			Student tempStudent = new Student("DuoLaiMi", "Lin", "happy@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the Java object
			System.out.println("Saving the student objet...");
			session.save(tempStudent); // 保存java对象

			// commit transaction
			session.getTransaction().commit();

			// 读取数据retrieve from db, primary key
			System.out.println("saved student, generated id: " + tempStudent.getId());

			session = factory.getCurrentSession(); // 写之后还是要新建session

			session.beginTransaction(); // CRUD在hibernate里面都需要transaction
			Student myStudent = session.get(Student.class, tempStudent.getId()); // 读取DB记录到Java对象
			System.out.println("Get complete: " + myStudent);
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally { // 无论成功与否都关掉factory
			factory.close();
		}

	}

}
