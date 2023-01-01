package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class StudentsTable {
	
	public static void topTenStudents() {
		
	}
	
    public static void topFifteenSubjects() {
	}
    
	  // the way of creating table in database using java code
    public static boolean isStudentsTableCreated() {
		

		String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 
			
		String StudentsTable = "CREATE TABLE Students (" 
		        + "id INT PRIMARY KEY,"  
		        + "fname VARCHAR(8)," 
		        + "lname VARCHAR(8),"  
		        + "birthdate date)"; 
		
	        Connection con = null;
	        
	        try {

	            Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
	            DriverManager.registerDriver(driver);
	            
	            con = DriverManager.getConnection(url, user,pass);
	            Statement st = con.createStatement();

	            int m = st.executeUpdate(StudentsTable);
	            if (m >=  1) {
	                System.out.println("table Students created successfully : " + StudentsTable);
	                return true;
	            }
	            else {
	                System.out.println("table Students not created, try again");
	            }
	            con.close();
	        } catch (Exception ex) {
	            System.err.println(ex);
	  }
	        return false;
	}
    
 // the way of inserting data in database using java code
    public static void addFakeStudents(int noOfArguments) {
    	
    	Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 
	     
	     for(int i=0;i<=noOfArguments;i++) {
	        int id =i;
	        String fname ="najateez";
	        String lname ="alkhatri";
	        String  birthdate ="1996-06-08";
	        
	        // Inserting data in database
            String q1 = "insert into students values('" +id+ "', '" +fname+
                                  "', '" +lname+ "', '" +birthdate+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             // Registering drivers
             DriverManager.registerDriver(driver);

             // Reference to connection interface
             con = DriverManager.getConnection(url, user,
                     pass);

             // Creating a statement/query
             Statement st = con.createStatement();

             // Executing query
             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println(
                         "inserted successfully : " + q1);
             else
                 System.out.println("insertion failed");

             // Closing the connections
             con.close();
         }

         // Catch block to handle exceptions
         catch (Exception ex) {
             // Display message when exceptions occurs
             System.err.println(ex);
         }
	     }
}

	
	public static void main(String[] args) {
		
		isStudentsTableCreated();
		addFakeStudents(29);
		
	}

}
