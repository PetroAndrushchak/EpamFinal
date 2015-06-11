package com.epam.project.controller.course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.model.Course;
import com.epam.project.db.service.CourseService;

@MultipartConfig
public class UpdateCommand implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Course course = new Course();
		course.setId(Integer.parseInt(request.getParameter("course_id")));
		course.setDescription(request.getParameter("description"));
		course.setIcon(request.getParameter("icon"));
		course.setName(request.getParameter("name"));
	

		if (course.isValid()) {

			CourseService.updateCourse(course);
			request.getRequestDispatcher(
					"/CourseServlet?action=show&course_id=" + course.getId())
					.forward(request, response);
			return;
		} else {
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

	}

	@Override
	public String getName() {

		return "update";
	}

}