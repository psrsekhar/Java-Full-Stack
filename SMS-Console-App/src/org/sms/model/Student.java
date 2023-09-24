package org.sms.model;

import java.util.Date;

public class Student {
	private Long id;
	private String name;
	private Gender gender;
	private String email;
	private String phno;
	private Date dob;
	private String address;

	public Student() {
	}

	public Student(Long id, String name, Gender gender, String email, String phno, Date dob, String address) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phno = phno;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}