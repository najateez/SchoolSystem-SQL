package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class SubjectsTable {
	
	// the way of creating table in database using java code
    public static boolean isSubjectsTableCreated() {
		

		String url = "jdbc:mysql://localhost:3306/schoolmgt";
		
		 String user = "root";
	     String pass = "10@104Ar$"; 
			
		String SubjectsTable = "CREATE TABLE Subjects (" 
		        + "subject_id INT PRIMARY KEY,"  
		        + "title VARCHAR(8)," 
		        + "descc VARCHAR(250),"  
		        + "pricePerStudent DECIMAL)"; 
		
	        Connection con = null;
	        
	        try {

	            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
	            DriverManager.registerDriver(driver);
	            
	            con = DriverManager.getConnection(url, user,pass);
	            Statement st = con.createStatement();

	            int m = st.executeUpdate(SubjectsTable);
	            if (m >=  1) {
	                System.out.println("table Subjects created successfully : " + SubjectsTable);
	                return true;
	            }
	            else {
	                System.out.println("table Subjects not created, try again");
	            }
	            con.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	  }
	        return false;
	}

	public static void main(String[] args) {
		
		isSubjectsTableCreated();

	}

}
