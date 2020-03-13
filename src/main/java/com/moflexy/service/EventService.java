package com.moflexy.service;

import java.util.List;

import com.moflexy.domain.Event;

public interface EventService {
	public List<Event> getAllEvents();
	
	public void addEvent(Event event);

}
