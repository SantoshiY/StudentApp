package com.studentappfinal.model;

import java.sql.ResultSet;


public interface DAOService {
	public void connectionDB();
	public boolean verifyCredentials(String id, String password);
	public void saveReg(String name, String city, String email, String mobile);
	public ResultSet saveAllReg();
	public void deleteById(String email);
	public void updateRecord(String email, String mobile);
}
