package com.epam.project.controller.group;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.project.command.Menu;
import com.epam.project.controller.visiting.ShowVisitingGroup;

/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/GroupServlet")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Menu menu;

	public GroupServlet() {
		super();
		menu = new Menu(new IndexGroup(), new NewGroup(), new DeleteGroup(),
				new CreateGroup(), new ShowGroup(), new EditGroup(),
				new UpdateGroup(), new GeoupUsersComand(),
				new RemoveUsersFromGroup(), new AddUsersToGroup(),
				new LeavUsersInGroup(), new RebaseUsers(),
				new GetTeacherGroups(), new ShowEvents(), new ShowExams(),
				new ShowTasks(), new GroupChat(), new GroupChatHistory(), new ShowVisitingGroup() );
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		menu.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		menu.execute(request, response);
	}

}