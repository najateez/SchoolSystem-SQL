package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		    int max=10000;
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
             DriverManager.registerDriver(driver);

             con = DriverManager.getConnection(url, user,pass);
             Statement st = con.createStatement();

             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println("inserted successfully : " + q1);
             else
                 System.out.println("insertion failed");

             con.close();
             
         }catch (Exception ex) {
             System.err.println(ex);
         }
	     }
}
    
    public static void top15Subjects(int top15Subjects) {
    	
	    String url = "jdbc:mysql://localhost:3306/schoolmgt";
	    String user = "root";
        String pass = "10@104Ar$";
    
		Scanner in = new Scanner(System.in);
		
		int count = 0;
		Connection con = null;
		
		try {
			 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			 DriverManager.registerDriver(driver);
			 con = DriverManager.getConnection(url, user, pass);
			 Statement st = con.createStatement();
			 
			 //as mr explaination on board
			 String sql = "SELECT * FROM subjects";
			 ResultSet rs = st.executeQuery(sql);  //ResultSet class import from library
			 
			while (rs.next() && count < top15Subjects) {
				int Subject_id = rs.getInt("Subject_id");
				String title = rs.getString("title");
				String descc = rs.getString("descc");
				float pricePerStudent = rs.getFloat("pricePerStudent");
				
				System.out.println(Subject_id + " " + title + " " + descc +" " + pricePerStudent + " ");
				count++;
			 }
			con.close();
		}catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		while(true) {
			System.out.println("School system sql (Subject) :");
			System.out.println("Menu:");
			System.out.println("1- Create subjects table.");
			System.out.println("2- Add fake subjects.");
			System.out.println("3- Select top 15 subjects.");
			System.out.println("4- Exit.");
			System.out.println("*******************************");
			System.out.println("enter a number from menu above:");
			int option=in.nextInt();
			
			switch(option) {
			case 1:{
				isSubjectsTableCreated();
				System.out.println("*******************************");
				break;
			}case 2:{
				addFakeSubjects(100);
				System.out.println("*******************************");
				break;
			}case 3:{
				top15Subjects(15);
				System.out.println("*******************************");
				break;
			}case 4:{
				return;
			}default:{
				System.out.println("it is not an option, try again.");
				System.out.println("*******************************");
			}
			}
		}
		
		
		
		
		

	}
		

}
