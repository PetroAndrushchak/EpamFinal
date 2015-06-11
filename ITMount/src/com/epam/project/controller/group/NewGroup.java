package com.epam.project.controller.group;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.service.CourseService;
import com.epam.project.db.service.UserService;

public class NewGroup implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("teachers", UserService.getByRole("teacher"));
		request.setAttribute("courses", CourseService.getAllCourses());
		request.getRequestDispatcher("/WEB-INF/group/new.jsp").forward(request,
				response);

	}

	@Override
	public String getName() {
		return "new";
	}

}
