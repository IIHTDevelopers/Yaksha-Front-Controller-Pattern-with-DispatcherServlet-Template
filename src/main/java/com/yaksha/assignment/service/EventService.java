package com.yaksha.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaksha.assignment.models.Event;
import com.yaksha.assignment.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	// Get all events
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	// Get an event by ID
	public Event getEventById(long id) {
		return eventRepository.findById(id);
	}

	// Add a new event
	public void addEvent(Event event) {
		eventRepository.save(event);
	}

	// Update an existing event
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}

	// Delete an event
	public void deleteEvent(long id) {
		eventRepository.delete(id);
	}
}
