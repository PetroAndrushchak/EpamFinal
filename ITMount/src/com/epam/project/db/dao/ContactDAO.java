package com.epam.project.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.project.db.model.Contact;
import com.epam.project.db.transformer.ContactTransformer;



public class ContactDAO {

	private static final String INSERT = "INSERT INTO contact(skype,phone,user_id) VALUES(?,?,?);";
	private static final String UPDATE = "UPDATE contact SET skype=?, phone=?, user_id=? WHERE id=?";
	private static final String DELETE = "DELETE FROM contact WHERE id=?";
	private static final String SELECTALL = "SELECT * FROM contact";
	private static final String SELECT = "SELECT * FROM contact WHERE id=?";
	
	public static void addConatct(Contact contact, Connection connection){
		try{
		PreparedStatement st = connection.prepareStatement(INSERT);
		st.setString(1,contact.getSkype());
		st.setString(2, contact.getPhone());
		st.setInt(3, contact.getUser_id());
		st.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	public static void delContact(Integer id,  Connection connection){
	
		try {
			
			PreparedStatement st = connection.prepareStatement(DELETE);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateContact(Contact contact, Connection connection){
		try {
			
			PreparedStatement st = connection.prepareStatement(UPDATE);
			
			st.setString(1, contact.getSkype());
			st.setString(2, contact.getPhone());
			st.setInt(3, contact.getUser_id());
			st.setInt(4, contact.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Contact> getAllContact(Connection connection){
		ResultSet rs = null;
		List<Contact> list = null;
		try {
		
			PreparedStatement st = connection.prepareStatement(SELECTALL);
			rs = st.executeQuery();
			list =ContactTransformer.getAllContact(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Contact getContact(Integer id,Connection connection){
		ResultSet rs = null;
		Contact contact =null;
		try {
			
			PreparedStatement st = connection.prepareStatement(SELECT);
			st.setInt(1, id);
			rs = st.executeQuery();
			contact= ContactTransformer.getContact(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}
	
}