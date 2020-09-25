package com.tanknavy.hibernate.inheritance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instructor2") // map to database table user
//@DiscriminatorValue(value="INSTRUCTOR") //在父类User的表中子类的标识值
public class Instructor2 extends User2 {

	private Double salary;
	
	public Instructor2(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	public Instructor2(String firstName, String lastName, Date dateOfBirth, String email) {
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
