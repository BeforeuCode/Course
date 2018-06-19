package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	

	public void addAccount() {

		
		System.out.println(getClass() + ": *DOING BD WORK: ADDING AN ACCOUNT*");
	}

}
