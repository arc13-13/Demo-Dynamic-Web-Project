package com.finall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class AddEntry {

	public String addInStudent(long l,String name) throws SQLException, ClassNotFoundException{
		
		   final String dbClassName = "com.mysql.jdbc.Driver";
		   final String CONNECTION = "jdbc:mysql://127.0.0.1/temp";
		                          
		  
		  	//Class.forName(className) loads the class with the specified className.
		    Class.forName(dbClassName);
		   
		
		    Properties p = new Properties();
		    p.put("user","archit");
		    p.put("password","archit13");
		
		
		    Connection connect = DriverManager.getConnection(CONNECTION,p);
		    PreparedStatement ps = connect.prepareStatement("insert into student values(?,?)");

		    ps.setLong(1, l);
		    ps.setString(2, name);
		    ps.executeUpdate();

		    connect.close();
		    return "success";
	}
}
