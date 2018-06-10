package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		   SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		   Session session = factory.getCurrentSession();
		   
		   try {
			//use the ssesion object to save Java object
			
			   //create student object
			   System.out.println("Creating new student object");
			   Student student = new Student("Pawelinio","Czubak","pawelcz1995@gmail.com");
			   
			   //start a transaction
			   session.beginTransaction();
			   //save the student obj
			   System.out.println("Saving the student object");
			   session.save(student);
			  
			   //commit
			   session.getTransaction().commit();
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
