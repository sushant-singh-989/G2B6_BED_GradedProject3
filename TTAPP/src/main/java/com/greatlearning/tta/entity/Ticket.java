package com.greatlearning.tta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "created_on")
	private String createdOn;

	public Ticket() {

	}

	public Ticket(String title, String shortDescription, String createdOn) {

		this.title = title;
		this.shortDescription = shortDescription;
		this.createdOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


}
