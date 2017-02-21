package com.springmvc.practice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmActorIdPK implements Serializable {
	
	@Column(name="actor_id")
	private Long actorId;
	@Column(name="film_id")
	private Long filmId;

}
