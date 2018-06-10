package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			   Student student = new Student("Maciej","Musial","mm@gmail.com");
			   
			   //start a transaction
			   session.beginTransaction();
			   //save the student obj
			   System.out.println("Saving the student object");
			   System.out.println(student);
			   session.save(student);
			  
			   //commit
			   session.getTransaction().commit();
			 
			   //Retriving an object
			   //find out the student primary key
			   System.out.println("Saved student. Genereted id: " + student.getId());
			   
			   
			   //now ger a new seession and start transaction 
			   session = factory.getCurrentSession();
			   session.beginTransaction();
			   //retrive the student based on the primary key
			   System.out.println("\nGetting student with id: " + student.getId());
			   
			   Student myStudent = session.get(Student.class, student.getId());
			    
			   System.out.println("Get complete: " + myStudent);
			   
			   
			   //commit
			   session.getTransaction().commit(); 
			   
			   
			   
			   
			   
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
