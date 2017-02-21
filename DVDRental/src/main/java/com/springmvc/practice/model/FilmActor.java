package com.springmvc.practice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="film_actor")
public class FilmActor  {
	@EmbeddedId
	private FilmActorIdPK id;
	@Column(name="last_update")
	private Date lastUpdated;
	
	public FilmActorIdPK getId() {
		return id;
	}
	public void setId(FilmActorIdPK id) {
		this.id = id;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
