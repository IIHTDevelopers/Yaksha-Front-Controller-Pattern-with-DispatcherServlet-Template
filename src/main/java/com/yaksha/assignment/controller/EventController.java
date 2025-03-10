package com.yaksha.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yaksha.assignment.models.Event;
import com.yaksha.assignment.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	// Display list of events
	@GetMapping("/")
	public String viewEvents(Model model) {
		model.addAttribute("events", eventService.getAllEvents());
		return "event-list";
	}

	// Show form to add a new event
	@GetMapping("/event/add")
	public String showAddEventForm(Model model) {
		model.addAttribute("event", new Event());
		return "add-event";
	}

	// Handle form submission to add a new event
	@PostMapping("/event/add")
	public String addEvent(@ModelAttribute Event event) {
		eventService.addEvent(event);
		return "redirect:/";
	}

	// Show form to edit an existing event
	@GetMapping("/event/edit/{id}")
	public String showEditEventForm(@PathVariable("id") long id, Model model) {
		Event event = eventService.getEventById(id); // Fetch the event by ID
		model.addAttribute("event", event); // Add the event to the model
		return "edit-event"; // Return the view for editing
	}

	// Handle form submission to update an event
	@PostMapping("/event/edit/{id}")
	public String updateEvent(@PathVariable("id") long id, @ModelAttribute Event event) {
		event.setId(id); // Ensure ID is preserved during edit
		eventService.updateEvent(event);
		return "redirect:/";
	}

	// Handle event deletion
	@GetMapping("/event/delete/{id}")
	public String deleteEvent(@PathVariable("id") long id) {
		eventService.deleteEvent(id);
		return "redirect:/";
	}
}
