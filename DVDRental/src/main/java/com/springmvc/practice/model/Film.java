package com.springmvc.practice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.practice.jsonview.Views;
@Entity
public class Film {
	@JsonView(Views.Public.class)
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="film_id")
	private Integer id ;
	@JsonView(Views.Public.class)
	private String title;
	@JsonView(Views.Public.class)
	private String description;
	@JsonView(Views.Public.class)
	@Column(name="release_year")
	private Integer releaseYear;
	@Column(name="language_id")
	private Integer languageId;
	@JsonView(Views.Public.class)
	@Column(name="rental_duration")
	private Integer rentalDuration;
	private Integer length;
	@Column(name="replacement_cost")
	private Integer replacementCost;
//	private Integer rating;
//	private Date last_update;
//	@Column(name="special_features")
//	private String specialFeatures;
//	private String fulltext;
	@Column(name="rental_rate")
	private Integer rentalRate;
	@Transient
	private String actorList;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public Integer getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(Integer replacementCost) {
		this.replacementCost = replacementCost;
	}
//	public String getSpecialFeatures() {
//		return specialFeatures;
//	}
//	public void setSpecialFeatures(String specialFeatures) {
//		this.specialFeatures = specialFeatures;
//	}
//	public String getFulltext() {
//		return fulltext;
//	}
//	public void setFulltext(String fulltext) {
//		this.fulltext = fulltext;
//	}
	public Integer getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(Integer rentalRate) {
		this.rentalRate = rentalRate;
	}
	public String getActorList() {
		return actorList;
	}
	public void setActorList(String actorList) {
		this.actorList = actorList;
	}
	
	
}
