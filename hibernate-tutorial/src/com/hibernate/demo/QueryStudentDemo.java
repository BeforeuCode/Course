package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		   SessionFactory factory = new Configuration()
									.configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		   Session session = factory.getCurrentSession();
		   
		   try {
			
			 
			  
			   
			   //start a transaction
			   session.beginTransaction();
			
			   //query students
			   
			 List<Student> theStudents = session.createQuery("from Student").list();
			 
			 //display students
			  displayStudents(theStudents);
				  
			  //query students : lastName ='czubak'
			  
			  theStudents = session.createQuery("from Student s where s.lastName='czubak'").list();
			  System.out.println("\n\nStudents with a alst name of czubak");
			  displayStudents(theStudents);
			  			  
			  theStudents = session.createQuery("from Student s where "
			  		+ " s.lastName='czubak' OR s.firstName='Adam'").list();
			  System.out.println("\n\nStudents with a last name of czubak or first Name of Adam");
			  displayStudents(theStudents);
			  
			  theStudents = session.createQuery("from Student s where "
				  		+ " s.email LIKE '%gmail.com'").list();
			  System.out.println("\n\nStudents with a email in gmail");
			  displayStudents(theStudents);
			  
			  //commit
			   session.getTransaction().commit();
			   System.out.println("Done");
			   
		   }
		   finally {
			   factory.close();
					}
		   
		   
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student : theStudents) {
			  
			  System.out.println(student);
		  }
	}

}
