package com.tanknavy.hibernate.one2many.uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	//@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) //除了delete级联
	@ManyToOne(cascade= CascadeType.ALL) //除了delete级联
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	//单向，主动参考项反而在java中没有field,所有添加到@OnetoMany的JoinColumn中
	//@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="course")//mappedBy参考是主动参考的栏位
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="course_id") //注意:是主动参考表的DB中column
	private List<Review> reviews;
	
	
	public Course() {
		super();
	}

	public Course(String title) {
		super();
		this.title = title;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	public void addReview(Review review){
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(review);
		//return reviews;
	}
	
}
