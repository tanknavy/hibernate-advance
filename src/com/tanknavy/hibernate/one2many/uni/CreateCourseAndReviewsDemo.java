package com.tanknavy.hibernate.one2many.uni;

// ��������ʱhibernate�İ�
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory,�����ļ���srcͬ��������Ҫָ����ע��JDBC��schema����
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg4.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			//Instructor tmpInstructor = new Instructor("Alex","Cheng","tanknavy@gmail.com"); //�ӱ�
			
			//InstructorDetail tmpInstructorDetail = 
			//new InstructorDetail("http://www.youtube.com/","Video Games");//����
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//int theId = 1; //instructor
			//Instructor tmpInstructor = session.get(Instructor.class, theId);
			
			Course course = new Course("Tableau Lesson");
			//Course course2 = new Course("React.js Lesson");
			//course.setInstructor(tmpInstructor);
			
			// associate the objects
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			course.addReview(new Review("I love this course, thanks"));
			course.addReview(new Review("I love this course, thanks"));
			course.addReview(new Review("What a dumb, you're a idiot!"));
			
			
			// start a transaction
			//session.beginTransaction();
			
			// save the Java object
			System.out.println("Saving the student objet...");
			//session.save(tmpInstructor); // CascadeType.ALL��������ӱ��¼(foreign key)Ҳ�ᱣ�游��ļ�¼
			//session.save(tmpInstructorDetail); //���游���������
			session.save(course); //session.save(course2);
			
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
