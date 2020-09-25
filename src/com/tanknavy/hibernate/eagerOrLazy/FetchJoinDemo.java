package com.tanknavy.hibernate.eagerOrLazy;

// ��������ʱhibernate�İ�
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
			//Instructor tmpInstructor = new Instructor("Alex","Cheng","tanknavy@gmail.com"); //�ӱ�
			
			//InstructorDetail tmpInstructorDetail = 
			//new InstructorDetail("http://www.youtube.com/","Video Games");//����
			
			// start a transaction
			session.beginTransaction();

			// Hibernate query with HQL
			
			int theId = 3;
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " //��ȡiȫ����λ
					+ "JOIN FETCH i.courses " // ������ȡ��ص�courses
					+ "where i.id=:theInstructorId", Instructor.class); //i��where����
			
			// set parameter on query
			query.setParameter("theInstructorId", theId); //HQL�Ĳ����趨
			
			// execute query and get instructor
			Instructor tmpInstructor = query.getSingleResult();//��ȡ������¼
			
			//Instructor tmpInstructor = session.get(Instructor.class, theId);
			System.out.println("Instructor: " + tmpInstructor); //Eager/Lazy
			//System.out.println("Courses: " + tmpInstructor.getCourses());
			
			//Course course1 = new Course("Java Lesson");
			//Course course2 = new Course("ETL Lesson");
			
			// associate the objects
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			//tmpInstructor.add(course1); //һ�Զ�
			//tmpInstructor.add(course2);
			
			// start a transaction
			//session.beginTransaction();
			
			// save the Java object
			//System.out.println("Saving the student objet...");
			//session.save(tmpInstructor); // CascadeType.ALL��������ӱ��¼(foreign key)Ҳ�ᱣ�游��ļ�¼
			//session.save(tmpInstructorDetail); //���游���������
			//session.save(course1); session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("session is closed! \n");
			System.out.println("Courses: " + tmpInstructor.getCourses());
			System.out.println("Done!");
			
		} 
		finally { //���۳ɹ���񶼹ص�factory
			session.close();
			factory.close();
		}
		
	}

}
