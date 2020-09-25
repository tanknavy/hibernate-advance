package com.tanknavy.hibernate.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tanknavy.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory,配置文件和src同级，否则要指定
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 13;

			// start a transaction
			session.beginTransaction(); // CRUD在hibernate里面都需要transaction
			Student myStudent = session.get(Student.class, studentId); // 读取DB记录到Java对象
			System.out.println("Before update: " + myStudent);
			
			// 删除一条记录
			session.delete(myStudent);; // 删除一条记录(java object)
			session.getTransaction().commit(); // 提交更新
			// 检查这条更新
			session = factory.getCurrentSession();
			session.beginTransaction(); // CRUD在hibernate里面都需要transaction
			myStudent = session.get(Student.class, studentId); // 读取DB记录到Java对象
			System.out.println("After update: " + myStudent);
			
			// 更新多条记录
			//session = factory.getCurrentSession();
			//session.beginTransaction();//没有commit就不能begin
			session.createQuery("delete from Student where email like '%fb.com%'").executeUpdate();
			session.getTransaction().commit(); // 提交更新
	

			System.out.println("Done!");

		} finally { // 无论成功与否都关掉factory
			factory.close();
		}

	}

}
