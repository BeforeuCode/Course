package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			   Student student = new Student("Adam","Mickiewicz","a.mickiewicz@gmail.com");
			   Student student2 = new Student("Juliusz","Slowacki", "j.slowacki@gmail.com");
			   Student student3 = new Student("Boleslaw", "Prus", "b.prus@gmail.com");	   
			   //start a transaction
			   session.beginTransaction();
			   //save the student obj
			   System.out.println("Saving the student object");
			   session.save(student);
			   session.save(student2);
			   session.save(student3);
			  
			   //commit
			   session.getTransaction().commit();
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
