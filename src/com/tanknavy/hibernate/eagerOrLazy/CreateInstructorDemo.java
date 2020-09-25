package com.tanknavy.hibernate.eagerOrLazy;

// ��������ʱhibernate�İ�
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory,�����ļ���srcͬ��������Ҫָ����ע��JDBC��schema����
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg3.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tmpInstructor = new Instructor("David","Cheng","tanknavy@gmail.com"); //�ӱ�
			
			InstructorDetail tmpInstructorDetail = 
					new InstructorDetail("http://www.youtube.com/","Video Games");//����
			
			//Course course = new Course("Java Lesson");
			
			// associate the objects
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the Java object
			System.out.println("Saving the student objet...");
			session.save(tmpInstructor); // CascadeType.ALL��������ӱ��¼(foreign key)Ҳ�ᱣ�游��ļ�¼
			//session.save(tmpInstructorDetail); //���游���������
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		finally { //���۳ɹ���񶼹ص�factory
			session.close();
			factory.close();
		}
		
	}

}
