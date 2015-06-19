package com.epam.project.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Action;
import com.epam.project.db.model.Contact;
import com.epam.project.db.model.Group;
import com.epam.project.db.model.User;
import com.epam.project.db.service.ContactService;
import com.epam.project.db.service.GroupService;
import com.epam.project.db.service.UserService;

public class UserHome implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User current_user = null;
		Integer user_id = null;
		if (request.getParameter("user_id") != null) {
			user_id = Integer.parseInt(request.getParameter("user_id"));
			current_user = UserService.getUser(user_id);
		}else{
			current_user = (User) request.getSession().getAttribute("user");
		}

		
		List<Group> groups = null;
		if (current_user.getRole().equals("applicant")
				|| current_user.getRole().equals("student")) {
			groups = GroupService.getGroupsUserStudy(current_user.getId());

			request.setAttribute("groups", groups);
		} else if (current_user.getRole().equals("lecturer")) {
			groups = GroupService.getByTeacher(current_user.getId());
			request.setAttribute("groups", groups);
		}

		Contact contacts = ContactService.getByUserId(current_user.getId());
		request.setAttribute("current_user", current_user);
		request.setAttribute("contact", contacts);
		request.getRequestDispatcher("/WEB-INF/user/home.jsp").forward(request,
				response);

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "index";
	}

}
