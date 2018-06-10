package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		   SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		   Session session = factory.getCurrentSession();
		   
		   try {
			
			int studentId = 1;
			 	
			   session = factory.getCurrentSession();
			   session.beginTransaction();
			 
			   Student myStudent = session.get(Student.class, studentId);
			   /*System.out.println("deleting student" + myStudent);   
			   session.delete(myStudent);*/
			   System.out.println("deleting student with id =2");
			   session.createQuery("delete from Student where id=2").executeUpdate();
			  
			   //commit
			   session.getTransaction().commit(); 
			   
			  
			   System.out.println(myStudent);
			   
			   System.out.println("Done");
			   
			  		   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
