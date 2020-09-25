package com.tanknavy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


// address将聚合到Student类中，作为成员属性
//@Entity //value type, no identifier(primary key)
@Table(name="address") // map to database table student
@Embeddable
public class Address {
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zipcode")
	private String zipcode;
}
