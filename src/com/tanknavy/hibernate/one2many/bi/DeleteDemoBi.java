package com.tanknavy.hibernate.one2many.bi;

// ��������ʱhibernate�İ�
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemoBi {

	public static void main(String[] args) {
		
		// create session factory,�����ļ���srcͬ��������Ҫָ����ע��JDBC��schema����
		SessionFactory factory = new Configuration().configure("resources/hibernate.cfg2.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key/id(�ӱ�)
			int theId = 7;
			//Instructor theInstructor = session.get(Instructor.class, theId);
			InstructorDetail theInStructorDetial = session.get(InstructorDetail.class, theId);
			
			System.out.println("Found instructorDetail: " + theInStructorDetial.toString());
			System.out.println("Found instructor: " + theInStructorDetial.getInstructor().toString()); // ��ָ��
			
			// delete the �ӱ�������
			if ( theInStructorDetial != null) {
				//�ؼ��㣺��Ҫ�����ӱ�Ĳο�����
				theInStructorDetial.getInstructor().setInstructorDetail(null);// ��Ҫupdate��null
				
				System.out.println("delete the java objet...");
				session.delete(theInStructorDetial); //CascadeType.ALL������ɾ�����¼
				
			}
	
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally { //���۳ɹ���񶼹ص�factory
			//session.close(); //�ر�session��ֹleak
			factory.close();
		}
		
	}

}
