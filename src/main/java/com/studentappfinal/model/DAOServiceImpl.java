package com.studentappfinal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DAOServiceImpl implements DAOService{
	private Connection con;
	private Statement stmnt;

	@Override
	public void connectionDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentappfinal","root","test");
			stmnt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyCredentials(String id, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where id = '"+id+"' and password = '"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet saveAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteById(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRecord(String email, String mobile) {
		try {
			stmnt.executeUpdate("update registration set mobile = '"+mobile+"' where email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
