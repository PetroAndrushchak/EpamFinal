package com.epam.project.db.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.epam.project.db.connection.DBConnection;
import com.epam.project.db.dao.GroupExamDAO;
import com.epam.project.db.dao.GroupUserDAO;
import com.epam.project.db.model.GroupExamModel;

public class GroupExamService {

	public static void createExam(GroupExamModel exam) {
		Connection connection = DBConnection.getConnection();
		GroupExamDAO.createExam(connection, exam);
		closeConnection(connection);
	}

	public static GroupExamModel getById(Integer exam_id) {
		GroupExamModel exam = null;
		Connection connection = DBConnection.getConnection();
		exam = GroupExamDAO.getByGroupId(connection, exam_id);
		closeConnection(connection);
		return exam;
	}

	public static List<GroupExamModel> getAll(Integer group_id) {
		Connection connection = DBConnection.getConnection();
		List<GroupExamModel> exams = null;
		exams = GroupExamDAO.getAll(connection, group_id);
		closeConnection(connection);
		return exams;
	}

	public static void setExamDate(Integer group_id, Integer user_id, Integer exam_id){
		Connection connection = DBConnection.getConnection();
		GroupUserDAO.setExamDate(connection, group_id, user_id, exam_id);
		closeConnection(connection);
	}
	private static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
