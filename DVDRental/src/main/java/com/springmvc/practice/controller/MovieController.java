package com.springmvc.practice.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.practice.jsonview.Views;
import com.springmvc.practice.model.Actor;
import com.springmvc.practice.model.Film;
import com.springmvc.practice.model.MovieFilter;
import com.springmvc.practice.service.ActorService;
import com.springmvc.practice.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService ;  
	@Autowired
	private ActorService actorService;
	
	
	final static Logger logger = Logger.getLogger(MovieController.class);
	
	@RequestMapping(value="/getFilm")
	public String getFilm(@ModelAttribute("movieFilter") MovieFilter movieFilter){
		
		return "film" ;
		
     	}
	
	@RequestMapping(value="/getAllMovies")
	public String getAllMovie(Model model , @ModelAttribute("film") Film film ,@ModelAttribute("movieFilter") MovieFilter movieFilter){
		List<Film> films = null;
		int paginatedMaxResult = 100;
		int currentPage = 1;
		int offset = ((currentPage-1) * paginatedMaxResult) ;
		logger.debug("This is offset value: " + offset);
		films = movieService.getAllMovies(offset, paginatedMaxResult);
		model.addAttribute("films", films);
		model.addAttribute("offset", offset);
		model.addAttribute("maxResults", movieService.count(film.getTitle(), film.getReleaseYear()));
		model.addAttribute("noOfPages", movieService.count(film.getTitle(), film.getReleaseYear())/paginatedMaxResult);
		return "film" ;
		
     	}
	
	@RequestMapping(value="/searchMovies")
	public  @ResponseBody List<Film> searchMovies(Model model, @RequestBody MovieFilter movieFilter){
		Integer actorId;
		int pageSize = 100;
		int currentPage = 1;
		int pageNumber = ((currentPage-1) * pageSize) ;
		logger.debug("This is offset value: " + pageNumber);
		if(movieFilter.getActor()==null){
			actorId = null;
		}
		else{
			actorId = movieFilter.getActor().getId();
		}
		List<Film> films = movieService.getFilteredMovies(movieFilter.getTitle(), movieFilter.getYear(), actorId, pageSize, pageNumber);
		model.addAttribute("films", films);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("movieFilter", movieFilter);
		//model.addAttribute("maxResults", movieService.count(film.getTitle(), film.getReleaseYear()));
		//model.addAttribute("noOfPages", movieService.count(film.getTitle(), film.getReleaseYear())/pageSize);
		return films ;
		
     	}
	
	@ModelAttribute("allActors")
    public List<Actor> populateActors() 
    {
        List<Actor> actors = actorService.getActors();
        return actors;
    }
	
	@ModelAttribute("allYears")
    public List<Integer> populateYears() 
    {
        List<Integer> years = movieService.getReleaseYears();
        return years;
    }
	
	@RequestMapping(value="/getPaginatedFilm")
	public String getPaginatedMovie(@RequestParam("currentPage") int currentPage, Model model , @ModelAttribute("film") Film film){
		int paginatedMaxResult = 100;
		//System.out.println("currentPage---" + currentPage);
		Integer offset = ((currentPage-1) * paginatedMaxResult) ;
		//System.out.println("offset" + offset);
		List<Film> films = movieService.getPaginatedMovie(film.getTitle(), offset, paginatedMaxResult);
		model.addAttribute("films", films);
		model.addAttribute("offset", offset);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxResults", movieService.count(film.getTitle(), film.getReleaseYear()));
		model.addAttribute("noOfPages", movieService.count(film.getTitle(), film.getReleaseYear())/paginatedMaxResult);
		return "film" ;
		
	}
	
	@RequestMapping(value="/getSortedMovies")
	public String getSortedMovies(@RequestParam("columnName") String columnName, Model model , @ModelAttribute("film") Film film ,@ModelAttribute("movieFilter") MovieFilter movieFilter){
		List<Film> films = null;
		
		int paginatedMaxResult = 100;
		int currentPage = 1;
		int offset = ((currentPage-1) * paginatedMaxResult) ;
		logger.debug("This is offset value: " + offset);
		logger.debug("Sort for column name : " + columnName);
		if( film.getTitle() == ""){
			film.setTitle(null);
		}
		
		if (film.getTitle()==null && film.getReleaseYear()==null){
			films = movieService.getAllMovies(offset, paginatedMaxResult);
		}
		else{
			if(! (film.getTitle()==null)){
				films = movieService.getMovieByName(film.getTitle(), offset, paginatedMaxResult);
			}
			else if(! (film.getReleaseYear()==null)){
				films = movieService.getMovieByYear(film.getReleaseYear(), offset, paginatedMaxResult);
			}
		}
		
		model.addAttribute("films", films);
		model.addAttribute("offset", offset);
		model.addAttribute("maxResults", movieService.count(film.getTitle(), film.getReleaseYear()));
		model.addAttribute("noOfPages", movieService.count(film.getTitle(), film.getReleaseYear())/paginatedMaxResult);
		
		return "film" ;
		
     	}
	
//	
//	@RequestMapping(value="/getFilmByName")
//	public String getMovieByName(Model model , @ModelAttribute("film") Film film){
//		int paginatedMaxResult = 100;
//		int currentPage = 1;
//		Integer offset = (currentPage-1) * paginatedMaxResult ;
//		List<Film> films = movieService.getMovieByName(film.getTitle(), offset, paginatedMaxResult);
//		model.addAttribute("films", films);
//		model.addAttribute("offset", offset);
//		model.addAttribute("maxResults", movieService.count(film.getTitle()));
//		model.addAttribute("noOfPages", movieService.count(film.getTitle())/paginatedMaxResult);
//		return "film" ;
//		
//	}
	
//	@RequestMapping(value="/getFilmByYear")
//	public String getMovieByYear(Model model , @ModelAttribute("film") Film film){
//		int paginatedMaxResult = 100;
//		int currentPage = 1;
//		Integer offset = (currentPage-1) * paginatedMaxResult ;
//		List<Film> films = movieService.getMovieByYear(film.getRelease_year(), offset, paginatedMaxResult);
//		model.addAttribute("films", films);
//		model.addAttribute("offset", offset);
//		model.addAttribute("maxResults", movieService.count(film.getTitle()));
//		model.addAttribute("noOfPages", movieService.count(film.getTitle())/paginatedMaxResult);
//		return "film" ;
//		
//	}
	
	
	
	@RequestMapping(value="/getHome")
	public String getHomePage(){
		
		return "../../index" ;
		
	}
	
	@RequestMapping(value="/addMovie")
	public String addFilm(@ModelAttribute ("film") Film film){
		 
		return "addFilm" ;
		
	}
	
	@RequestMapping(value="/saveFilms" )
	public String saveFilm(@ModelAttribute ("film") Film film){
		
		movieService.saveFilm(film);
		
		return "redirect:index.jsp" ;
		
	}

	

}
