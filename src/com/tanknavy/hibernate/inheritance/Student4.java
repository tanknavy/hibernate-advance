package com.tanknavy.hibernate.inheritance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student4") // map to database table user
//@DiscriminatorValue(value="STUDENT") //在父类User的表中子类的标识值
public class Student4 extends User4 {

	private String course;
	
	public Student4(String firstName, String lastName, String email, String course) {
		super(firstName, lastName, email); //父类构造器
		this.course = course; //子类字段
	}

	public Student4(String firstName, String lastName, Date dateOfBirth, String email) {
		super(firstName, lastName, dateOfBirth, email);
		// TODO Auto-generated constructor stub
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	

}
