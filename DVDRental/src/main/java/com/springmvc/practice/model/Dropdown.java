package com.springmvc.practice.model;


import org.springframework.context.annotation.Configuration;

@Configuration("dropdown")
public class Dropdown {
	
	String actorList;
	
	
	public String getActorList() {
		return actorList;
	}
	
	public void setActorList(String actorList) {
		this.actorList = actorList;
	}
	

}
