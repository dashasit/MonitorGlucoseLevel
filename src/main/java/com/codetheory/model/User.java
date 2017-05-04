package com.codetheory.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class User {

	
	private int id;

	
	private String firstName;

	
	private String lastName;

	
	private Date dob;

	
	private String loginId;

	
	private String password;

	
	private Set<UserGlucoseHistory> glucoseHistories;

	public User() {

	}

	public User(String firstName, String lastName, Date dob, String loginId,
			String password, Set<UserGlucoseHistory> glucoseHistories) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.loginId = loginId;
		this.password = password;
		this.glucoseHistories = glucoseHistories;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
