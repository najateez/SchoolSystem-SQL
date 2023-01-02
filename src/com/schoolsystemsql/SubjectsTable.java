package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

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
    
    
 // the way of inserting data in database using java code
    public static void addFakeSubjects(long noOfArguments) {
    	
    	Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 

	     
	     for(int i=0;i<=noOfArguments;i++) {
	    	//to get random value of id(between 0 to 100).
	    	int min=0;
		    int max=100;
		    int Subject_id = (int)Math.floor(Math.random()*(max-min+1)+min); 
	        String title ="java";
	        String descc ="Java is an object-oriented programming language that produces software for multiple platforms.";
	        float pricePerStudent = 150f;
	        
	        // Inserting data in database
            String q1 = "insert into subjects values('" +Subject_id+ "', '" +(title+i)+
                                  "', '" +(descc+i)+ "', '" +pricePerStudent+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             // Registering drivers
             DriverManager.registerDriver(driver);

             // Reference to connection interface
             con = DriverManager.getConnection(url, user,pass);

             // Creating a statement/query
             Statement st = con.createStatement();

             // Executing query
             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println("inserted successfully : " + q1);
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
    
    public static void topFifteenSubjects() {
	//	String topFifteenSubjectsSql="SELECT * FROM Subjects limit 15";
	}

	public static void main(String[] args) {
		
		isSubjectsTableCreated();
		addFakeSubjects(100);
		

	}

}
