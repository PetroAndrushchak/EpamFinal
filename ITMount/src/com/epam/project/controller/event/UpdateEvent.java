package com.epam.project.controller.event;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.model.Event;
import com.epam.project.db.service.EventService;

public class UpdateEvent implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Event event = new Event();

		event.setId(Integer.parseInt(request.getParameter("event_id")));
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
		
		event.setIs_active(Boolean.parseBoolean(request
				.getParameter("is_active")));

		Integer event_id = event.getId();

		if (event.isValid()) {

			EventService.update(event);
			response.sendRedirect(request.getHeader("Referer"));
			return;
		} else {
			response.sendError(404);;
			return;
		}
	}

	@Override
	public String getName() {

		return "update";
	}

}