package com.epam.project.controller.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.model.Task;
import com.epam.project.db.service.TaskService;

public class CreateTaskCommand implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Task task = new Task();
		boolean correctDate = true;

		task.setName(request.getParameter("task_name"));
		task.setDescription(request.getParameter("task_description"));

		String stringDateDeadline = request.getParameter("task_deadline");

		System.out.println("String = " + stringDateDeadline);
		Date dateDeadline = null;
		DateFormat deadline = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		try {
			dateDeadline = deadline.parse(stringDateDeadline);
		} catch (ParseException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		
		task.setAvailable(true);

		String pathFile = request.getParameter("task_file");
		task.setFile(pathFile);
		task.setIs_active(true);

		int idGroup = Integer.parseInt(request.getParameter("id_group"));
		task.setGroupID(idGroup);
		task.setDeadline(dateDeadline);
		
		if (task.isValid()) {

			if (task.getDeadline() != null) {
				if (checkDate(task.getDeadline()) == false) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					return;
				}
				TaskService.addNewTask(task);
			}
			return;

		} else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

	}

	@Override
	public String getName() {

		return "createTask";
	}

	private boolean checkDate(Date deadline) {

		boolean dateCorrect = true;

		Calendar cal = Calendar.getInstance();
		cal.setTime(deadline);

		int year = cal.get(Calendar.YEAR);

		if (year < 1970 || year > 2030) {
			dateCorrect = false;
		}

		return dateCorrect;
	}

}
