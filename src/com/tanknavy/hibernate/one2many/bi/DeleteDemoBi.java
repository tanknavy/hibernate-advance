package com.tanknavy.hibernate.one2many.bi;

// 操作数据时hibernate的包
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemoBi {

	public static void main(String[] args) {
		
		// create session factory,配置文件和src同级，否则要指定，注意JDBC中schema连接
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key/id(子表)
			int theId = 7;
			//Instructor theInstructor = session.get(Instructor.class, theId);
			InstructorDetail theInStructorDetial = session.get(InstructorDetail.class, theId);
			
			System.out.println("Found instructorDetail: " + theInStructorDetial.toString());
			System.out.println("Found instructor: " + theInStructorDetial.getInstructor().toString()); // 空指针
			
			// delete the 子表级联父表
			if ( theInStructorDetial != null) {
				//关键点：先要设置子表的参考连接
				theInStructorDetial.getInstructor().setInstructorDetail(null);// 先要update到null
				
				System.out.println("delete the java objet...");
				session.delete(theInStructorDetial); //CascadeType.ALL级联将删除表记录
				
			}
	
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally { //无论成功与否都关掉factory
			//session.close(); //关闭session防止leak
			factory.close();
		}
		
	}

}
