package com.yaksha.assignment.models;

public class Event {

	private long id;
	private String name;
	private String date;
	private String description;

	// Constructors
	public Event() {
	}

	public Event(long id, String name, String date, String description) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.description = description;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description + "]";
	}
}
