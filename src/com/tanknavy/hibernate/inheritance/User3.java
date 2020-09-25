package com.tanknavy.hibernate.inheritance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//类的继承和ORM

@Entity
@Table(name="user3") // map to database table user
@Inheritance(strategy = InheritanceType.JOINED)//单表，多表，join表，映射超类，默认单表
//@DiscriminatorColumn(name="USER_TYPE", discriminatorType=DiscriminatorType.STRING) //标准子类的table栏位名
public abstract class User3 { //抽象类
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //DB AUTO_INCREMENT
	//跨多个表，id由各自表维护，hi会自动创建sequence table，线程安全地带取得下一个next_val
	//为了访问sequence table, 增加线程池中线程数量
	//如果是mysql8, 为了创建sequence table, 更新alect.MySQLDialect为alect.MySQL8Dialect
	//@GeneratedValue(strategy=GenerationType.TABLE)//跨多个表，hi将创建sequence table在数据库中并维护hibernate_sequences表
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
	@Temporal(TemporalType.DATE) //date,time,timestamp
	private Date dateOfBirth; // java.util.Date;
	
	@Column(name="email")
	private String email;
	
	public User3() {
		
	}
	
	//����id��database������primary key,���Թ��캯���в���id
	public User3(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// ���������ֶ�
	public User3(String firstName, String lastName, Date dateOfBirth, String email) {
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
	
	//id is automatically increment in DB
//	public void setId(int id) {
//		this.id = id;
//	}

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

	
	
}
