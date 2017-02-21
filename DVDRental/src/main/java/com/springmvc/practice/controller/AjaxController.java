package com.springmvc.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.practice.jsonview.Views;
import com.springmvc.practice.model.Film;
import com.springmvc.practice.model.MovieFilter;
import com.springmvc.practice.service.MovieService;

@RestController
public class AjaxController {
	
	@Autowired
	MovieService movieService;
	@JsonView(Views.Public.class)
	@RequestMapping(value="/searchRequestedMovies", method=RequestMethod.POST)
	public List<Film> searchMovies(@RequestBody MovieFilter movieFilter){
		Integer actorId;
		int pageSize = 100;
		int currentPage = 1;
		int pageNumber = ((currentPage-1) * pageSize) ;
		//logger.debug("This is offset value: " + pageNumber);
		if(movieFilter.getActor()==null){
			actorId = null;
		}
		else{
			actorId = movieFilter.getActor().getId();
		}
		List<Film> films = movieService.getFilteredMovies(movieFilter.getTitle(), movieFilter.getYear(), actorId, pageSize, pageNumber);
		
		return films;

	}

}
