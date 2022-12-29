package com.schoolsystemsql;


import java.sql.*;
import java.util.*;

public class SubjectTable {

	public static void main(String[] args) {
		isSubjectTableCreated();
	}
	 
		public static boolean isSubjectTableCreated() {
			

			String url = "jdbc:mysql://localhost:3306/schoolmgt";
			
			 String user = "root";
		     String pass = "10@104Ar$"; 
				
			String subjectsTable = "CREATE TABLE Subject (" 
			        + "id INT NOT NULL,"  
			        + "title VARCHAR(8)," 
			        + "descc VARCHAR(250),"  
			        + "pricePerStudent DECIMAL)"; 
			
		        Connection con = null;
		        
		        try {

		            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		            DriverManager.registerDriver(driver);
		            
		            con = DriverManager.getConnection(url, user,pass);
		            Statement st = con.createStatement();

		            int m = st.executeUpdate(subjectsTable);
		            if (m >=  1) {
		                System.out.println("table subject created successfully : " + subjectsTable);
		                return true;
		            }
		            else {
		                System.out.println("table subject not created, try again");
		            }
		            con.close();
		        } catch (Exception ex) {
		            System.err.println(ex);
		  }
		        return false;
		
		
		


	}

}
