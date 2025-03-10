package com.yaksha.assignment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaksha.assignment.models.Event;

@Repository
public class EventRepository {

	private List<Event> events = new ArrayList<>();
	private long nextId = 1;

	// Get all events
	public List<Event> findAll() {
		return events;
	}

	// Find an event by ID
	public Event findById(long id) {
		return events.stream().filter(event -> event.getId() == id).findFirst().orElse(null);
	}

	// Save an event (add or update)
	public void save(Event event) {
		if (event.getId() == 0) {
			event.setId(nextId++);
			events.add(event);
		} else {
			events.removeIf(e -> e.getId() == event.getId());
			events.add(event);
		}
	}

	// Delete an event
	public void delete(long id) {
		events.removeIf(event -> event.getId() == id);
	}
}
