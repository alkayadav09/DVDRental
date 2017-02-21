package com.springmvc.practice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.practice.model.Actor;
import com.springmvc.practice.service.ActorService;

@Controller
public class ActorController {

	@Autowired
	private ActorService actorService ; 
	
	@RequestMapping(value="/getActors")
	public String getActors(Model model , @ModelAttribute("actors") Actor actor){
		
		List<Actor> actors = new ArrayList<Actor>();
		actors = actorService.getActors();
		model.addAttribute("actors", actors);
		return "actor";
		
		
	}
	
	@RequestMapping(value="/addActor")
	public String addActor(@ModelAttribute("actor") Actor actor){
		
		return "addActor";
	}
	
	@RequestMapping(value="/saveActor")
	public String save(@ModelAttribute("actor") Actor actor){
		actor.setLastUpdate(new Date());
		actorService.saveActor(actor);
		return "redirect:index.jsp";
	}
}
