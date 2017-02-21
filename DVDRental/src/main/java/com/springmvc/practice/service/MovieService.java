package com.springmvc.practice.service;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.practice.model.Film;
import com.springmvc.practice.repository.MovieRepository;

@Service("movieService")
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository ;
	

	public List<Film> getAllMovies(Integer offset , Integer maxResults){
		
		return movieRepository.getAllMovies(offset, maxResults);
	}
	
	public List<Integer> getReleaseYears(){
		
		return movieRepository.getReleaseYears();
	}
	
	public List<Film> getPaginatedMovie(String title , Integer offset , Integer paginatedMaxResult){
		
		return movieRepository.getPaginatedMovie(title, offset , paginatedMaxResult);
	}
	
	public List<Film> getSortedMovies(Integer offset , Integer maxResults, String columnName){
		
		return movieRepository.getSortedMovies(offset, maxResults, columnName);
	}
	
	public List<Film> getFilteredMovies(String title , Integer year , Integer actorId , int pageSize , int pageNumber ){
		Integer releaseYear = year;
		if(title == ""){
			title = null;
		}
		if(year == -1){
			releaseYear = null;
		}
	
		return movieRepository.getFilteredMovies(title, releaseYear, actorId, pageSize, pageNumber);
	}
	
	public List<Film> getMovieByName(String title , Integer offset , Integer maxResults){
		
		return movieRepository.getMovieByName(title , offset , maxResults);
	}
	

	public List<Film> getMovieByYear(Integer year , Integer offset , Integer maxResults){
		
		return movieRepository.getMovieByYear(year , offset , maxResults);
	}
	
	public List<Film> getMovieByActor(Integer year , Integer offset , Integer maxResults){
		
		return movieRepository.getMovieByActor(year , offset , maxResults);
	}
	
	public Long count(String title, Integer year){
		return movieRepository.count(title, year);
	}
	
	@Transactional
	public Film saveFilm(Film film){
		
		return movieRepository.saveFilm(film);
		
	}

}
