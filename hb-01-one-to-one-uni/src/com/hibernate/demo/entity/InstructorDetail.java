package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	//entityy and map to db table
	@Entity
	@Table(name = "instructor_detail")
	public class InstructorDetail {
	//define fields
		//anotate fields
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@Column(name = "hobby")
		private String hobby;

		@Column(name = "youtube_channel")
		private String youtubeChannel;
		
		//constructors
	public InstructorDetail() {
			
	}

	public InstructorDetail( String hobby, String youtubeChannel) {
			
			
			this.hobby = hobby;
			this.youtubeChannel = youtubeChannel;
	}
	//getters setters 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getHobby() {
		return hobby;
	}

	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	// toString 
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobby=" + hobby + ", youtubeChannel=" + youtubeChannel + "]";
	}

	
}
