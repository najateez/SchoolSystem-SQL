package com.schoolsystemsql;

import java.sql.*;
import java.util.*;

public class Table {
	
	
	public static void topten() {
		String studentSql="SELECT * FROM Students ORDER BY id LIMIT 10;";
	}
	
	
	public static void topFifteen() {
		String studentSql="SELECT * FROM Subject ORDER BY id LIMIT 15;";
	}
	
	public static void addFakeStudents() {
		
	}
	


	public static void main(String[] args) {
		isStudentTableCreated();
	}
		public static boolean isStudentTableCreated() {

		String url = "jdbc:mysql://localhost:3306/schoolmgt";
		
		 String user = "root";
	     String pass = "10@104Ar$";
		
		String studentsTable = "CREATE TABLE Students (" 
		        + "id INT PRIMARY KEY,"  
		        + "fname VARCHAR(8)," 
		        + "lname VARCHAR(8),"  
		        + "birthdate DATE)";   
	        Connection con = null;
	        
	        try {

	            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
	            DriverManager.registerDriver(driver);
	            
	            con = DriverManager.getConnection(url, user,pass);
	            Statement st = con.createStatement();

	            int m = st.executeUpdate(studentsTable);
	            if (m >=  1) {
	                System.out.println("table students created successfully : " + studentsTable);
	              return true;
	            }
	            else 
	                System.out.println("table students not created, try again");
	           
	            con.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	  }

	        return false;
	        
	        
		

	}

}
