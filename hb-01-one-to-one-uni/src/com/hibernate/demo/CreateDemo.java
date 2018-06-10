package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

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
			   //create object
			   Instructor instructor = 
					   new Instructor("Maciek","Wodzynski", " m.wodzynski@gmail.com");
			   
			   InstructorDetail instructorDetail = 
					   new InstructorDetail("walenie konia","youtube.com/wodzu");
			   
			   //associate the objects
			   
			   instructor.setInstructorDetail(instructorDetail);
			   
			   //start a transaction
			   session.beginTransaction();
			   
			  //save the instructor
			   //NOTE : this will aslo save te deatial because of Cascadetype.all
			   System.out.println("Saving instructor: " + instructor);
			   session.save(instructor);
			   //commit
			   session.getTransaction().commit();
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

}
