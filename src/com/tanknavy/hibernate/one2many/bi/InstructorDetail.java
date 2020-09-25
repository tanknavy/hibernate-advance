package com.tanknavy.hibernate.one2many.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	// annoate the class as an entity and map to db
	
	// define the fields
	
	// annoate the fields with db columns names
	
	// create constructor
	
	// getter/setter
	
	// toString()
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto_increment
	@Column(name="id")
	private int id;
	@Column(name="youtube_channel")
	private String youtubeChannel;
	@Column(name="hobby")
	private String hobby;
	
	
	// bi @OneToOne, 不对应DB中的栏位
	//@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL),全部级联
	@OneToOne(mappedBy="instructorDetail",
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//除了delete
	private Instructor instructor;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	

	public InstructorDetail(String youtubeChannel, String hobby, Instructor instructor) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	
}
