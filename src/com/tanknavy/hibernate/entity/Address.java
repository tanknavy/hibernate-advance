package com.tanknavy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


// address将聚合到Student类中，作为成员属性, address栏位放到Student中，没有address表
// reuse the address in other class, 重用
//@Entity //value type, no identifier(primary key)
//@Table(name="address") // map to database table student, all fields will be aggregate to embedded table Student
@Embeddable
public class Address {
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zipcode")
	private String zipcode;

	public Address() { //框架需要空参构造
	}

	public Address(String street, String city, String zipcode) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
}
