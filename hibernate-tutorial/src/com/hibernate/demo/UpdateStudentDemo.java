package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		   SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		   Session session = factory.getCurrentSession();
		   
		   try {
			
			
			 	
			   session = factory.getCurrentSession();
			   session.beginTransaction();
			   
			   System.out.println("Update email for all students");
			   session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			   session.getTransaction().commit(); 
			  
			   //start a transaction
			   session = factory.getCurrentSession();
			   session.beginTransaction();
			
			
			  int studentId = 1;
			   System.out.println("\nGetting student with id: " + studentId );
			   
			   Student myStudent = session.get(Student.class, studentId );
			    
			   System.out.println("Updating student");
			   myStudent.setFirstName("Scooby");
			   
			   
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
