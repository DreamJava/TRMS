package com.moflexy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.moflexy.domain.Event;
import com.moflexy.service.EventService;
import com.moflexy.service.EventServiceImpl;

public class EventServlet extends HttpServlet {

	EventService eventService = new EventServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Event> eventList = eventService.getAllEvents();
		String eventListJSON = new GsonBuilder().create().toJson(eventList);
		PrintWriter pw = resp.getWriter();
		pw.write(eventListJSON);
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

}
