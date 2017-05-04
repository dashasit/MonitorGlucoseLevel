package com.codetheory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

public class UserGlucoseHistory {

	private long id;

	private int userId;

	private int glucoseLevel;

	private Date lastmodified;

	public UserGlucoseHistory() {

	}

	public UserGlucoseHistory(int userId, int glucoseLevel, Date lastmodified) {
		super();
		this.userId = userId;
		this.glucoseLevel = glucoseLevel;
		this.lastmodified = lastmodified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGlucoseLevel() {
		return glucoseLevel;
	}

	public void setGlucoseLevel(int glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

}
