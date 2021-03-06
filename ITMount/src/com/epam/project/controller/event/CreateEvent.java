package com.epam.project.controller.event;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.model.Event;
import com.epam.project.db.service.EventService;
import com.google.gson.Gson;

public class CreateEvent implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Event event = new Event();
		event.setDescription(request.getParameter("description"));
		event.setNameEvent(request.getParameter("eventName"));
		event.setTypeEvent(request.getParameter("typeEvent"));
		
		try {
			event.setDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
					.parse(request.getParameter("date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		event.setGroup_id(Integer.parseInt(request.getParameter("group_id")));

		
		Gson json = new Gson();
		
		if(event.isValid()){
			event = EventService.getById(EventService.newEvent(event));
		}
		
			/*
			response.setContentType("application/json");
			response.getWriter().write(json.toJson(event));
		*/
		response.sendRedirect(request.getHeader("Referer"));

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "create";
	}

}
