package com.springmvc.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.springmvc.practice.model.Actor;

public class ActorConverter implements Converter<String, Actor>{
	
	@Autowired
	private ActorService actorService;
	
	public Actor convert(String id) {
		
		Integer actorId = Integer.parseInt(id);
		if(actorId == -1){
			return null;
		}
		Actor a = actorService.getActorsById(actorId);
		return a;
		
	}

	

}
