package com.tanknavy.hibernate.inheritance;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="INSTRUCTOR") //在父类User的表中子类的标识值
public class Instructor extends User {

	private Double salary;
	
	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	public Instructor(String firstName, String lastName, Date dateOfBirth, String email) {
		super(firstName, lastName, dateOfBirth, email);
		// TODO Auto-generated constructor stub
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}
