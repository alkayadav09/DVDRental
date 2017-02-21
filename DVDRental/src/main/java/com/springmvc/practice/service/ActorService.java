package com.springmvc.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.practice.model.Actor;
import com.springmvc.practice.repository.ActorRepository;

@Service("actorService")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository; 
	
	public List<Actor> getActors(){
		
		return actorRepository.getActors();
	}

	@Transactional
	public Actor saveActor(Actor actor) {
		
		return actorRepository.saveActor(actor);
		
	}

	public Actor getActorsById(Integer id) {
		
		return actorRepository.getActorById(id);
		
	}

}
