package com.tanknavy.hibernate.many2many;

import java.util.ArrayList;
import java.util.List;

// ��ģjava class�Ƕ���javax�İ�
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	// �����ڳ�����cascade��������db�У�����DB��on update no action on delete no action
	// one-to-one table mapping
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id") // �����ֶ���
	private InstructorDetail instructorDetail; //����(��references�ı�)����
	
	//���ο���mappedByû��DB��λ
	@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor",cascade= 
		{CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) // ע�����ο���û��DB��λ
	private List<Course> courses;
	
	
	public Instructor() {
		
	}
	
	// id��db���������Բ���Ҫ��ͬʱinstructorDetail�ǲο��������ͣ�����set���趨
	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	// add convenience methods for bi relationship
	public void add(Course tmpCourse) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tmpCourse);
		
		tmpCourse.setInstructor(this); //��ǰinstructor������ӵ��γ���
	}
	
	
}
