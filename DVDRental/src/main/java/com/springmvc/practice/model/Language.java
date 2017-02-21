package com.springmvc.practice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class Language {

	@Id
	@Column(name="language_id")
	private Long id;
	private String name;
	@Column(name="last_updated")
	private Date lastUpdated;
	
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
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
