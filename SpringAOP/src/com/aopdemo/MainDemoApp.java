package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read config
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//busines method
		theAccountDAO.addAccount();
		
		
		
		//close the context
		context.close();

	}

}
