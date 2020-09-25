package com.tanknavy.hibernate.many2many;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseForStudent {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定，注意JDBC中schema连接
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg5.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			//Instructor tmpInstructor = new Instructor("Alex","Cheng","tanknavy@gmail.com"); //子表
			
			//InstructorDetail tmpInstructorDetail = 
			//new InstructorDetail("http://www.youtube.com/","Video Games");//父表
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			int theId = 2; //student
			//Instructor tmpInstructor = session.get(Instructor.class, theId);
			//Student student1 = new Student("Mary","Cheng","Alex.Cheng@gmail.com");
			//Student student2 = new Student("David","Cheng","Alex.Cheng@gmail.com");
			Student student = session.get(Student.class, theId);
			System.out.println(student.getCourses());
			
			Course course1 = new Course("Nolang Lesson");
			Course course2 = new Course("Unix Lesson");
			//Course course2 = new Course("React.js Lesson");
			//course.setInstructor(tmpInstructor);
			
			// associate the objects
			//tmpInstructor.setInstructorDetail(tmpInstructorDetail);
			//course1.addStudent(student1);
			//course1.addStudent(student2);
			//course2.addStudent(student2);
			student.addCourse(course1);student.addCourse(course2);
			System.out.println(student.getCourses());
			
			
			// start a transaction
			//session.beginTransaction();
			
			// save the Java object
			System.out.println("Saving the student objet...");
			//session.save(tmpInstructor); // CascadeType.ALL保存带有子表记录(foreign key)也会保存父表的记录
			//session.save(tmpInstructorDetail); //保存父表不会外键表
			//session.save(student);
			session.save(course1); session.save(course2);

			//session.save(student1); session.save(student2);

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		finally { //无论成功与否都关掉factory
			session.close();
			factory.close();
		}
		
	}

}
