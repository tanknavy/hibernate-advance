package com.tanknavy.hibernate.many2many;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student") // map to database table student
public class Student {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //mysql AUTO_INCREMENT
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	/*
	// 在DB的column，DATETIME类型，类型'1990-08-05 00:00:00'
	// 在Java的field中，java.util.Date类型,SimpleDateFormat("MM/dd/yyyy");;
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE) //date,time,timestamp
	private Date dateOfBirth; // java.util.Date;
	*/
	
	@Column(name="email")
	private String email;
	
	// 多对多
	@ManyToMany(fetch=FetchType.LAZY,
			//cascade=CascadeType.ALL)
			cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
			name="course_student", 
			joinColumns=@JoinColumn(name="student_id"), 
			inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	

	public Student() {
		
	}
	
	//这里id是database中自增primary key,所以构造函数中不加id
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// 带有日期字段
	public Student(String firstName, String lastName, Date dateOfBirth, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		//this.dateOfBirth = dateOfBirth;
		this.email = email;
	}
	

	//测试目的
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				//+ ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + "]";
				//+ DateUtils.formatDate(dateOfBirth) + ", email=" + email + "]"; //Date类型转字符串
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}*/

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(course);
	}
	
}
