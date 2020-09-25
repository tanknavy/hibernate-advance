package com.tanknavy.hibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//collection List(ordered)

@Entity
@Table(name="studentMap") // map to database table student
public class StudentMap {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //mysql AUTO_INCREMENT
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	// ��DB��column��DATETIME���ͣ�����'1990-08-05 00:00:00'
	// ��Java��field�У�java.util.Date����,SimpleDateFormat("MM/dd/yyyy");;
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE) //date,time,timestamp
	private Date dateOfBirth; // java.util.Date;
	
	@Column(name="email")
	private String email;
	

	//join to table "image" on student2.id = image.student_id， 
	@ElementCollection
	@CollectionTable(name="image3" )//, joinColumns = @JoinColumn(name="student_id")) //joinColumns can be ignored!
	@MapKeyColumn(name="file_name")
	@Column(name="image_name") //defaults to images, map to table image(file_name)
	private Map<String, String> images = new HashMap<String, String>(); //List
	
	
	//--------constructor------------
	public StudentMap() {
		
	}
	
	//����id��database������primary key,���Թ��캯���в���id
	public StudentMap(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// ���������ֶ�
	public StudentMap(String firstName, String lastName, Date dateOfBirth, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}
	

	//����Ŀ��
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + "]";
				//+ DateUtils.formatDate(dateOfBirth) + ", email=" + email + "]"; //Date����ת�ַ���
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Map<String,String> getImages() {
		return images;
	}

	public void setImages(Map<String,String> images) {
		this.images = images;
	}
	
	
	
	
}
