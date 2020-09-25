package com.tanknavy.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="studentEnum") // map to database table student
public class StudentEnum {
	
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
	//In plain Java APIs, the temporal precision of time is not defined. When dealing with temporal data, 
	//you might want to describe the expected precision in database.Temporal data can have DATE, TIME, or TIMESTAMP precision
	//(i.e., the actual date, only the time, or both). Use the @Temporal annotation to fine tune that.
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE) //date,time,timestamp精确控制
	private Date dateOfBirth; // java.util.Date;
	
	@Column(name="email")
	private String email;
	
	@Enumerated(EnumType.STRING) //字符串类型enum
	@Column(name="status")
	private Status status; //聚合枚举类Enum
	
	public StudentEnum() {
		
	}
	
	//����id��database������primary key,���Թ��캯���в���id
	public StudentEnum(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// ���������ֶ�
	public StudentEnum(String firstName, String lastName, Date dateOfBirth, String email) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
