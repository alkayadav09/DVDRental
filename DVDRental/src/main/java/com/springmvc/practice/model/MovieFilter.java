package com.springmvc.practice.model;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieFilter {
	
	private String title;
	private Integer year;
	@Autowired
	private Actor actor;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
