package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		   SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		   Session session = factory.getCurrentSession();
		   
		   try {
			  
			    
			   //start a transaction
			   session.beginTransaction();
			   
			  //get instructior by key/id
			   int theID = 2;
			   Instructor instructor = session.get(Instructor.class,theID);
			   System.out.println("Found: " + instructor);
			   //delete
			   if(instructor != null) {
				   System.out.println("Deleting: " + instructor );
				   //Note: Also delete details 
				   session.delete(instructor);
			   }
			   
			  //commit
			  session.getTransaction().commit();
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
