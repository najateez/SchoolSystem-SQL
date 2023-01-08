package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentsTable {
	
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
    public static void addFakeStudents(long noOfArguments) {
    	
    	Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 

	     
	     for(int i=0;i<=noOfArguments;i++) {
	    	//to get random value of id(between 0 to 100).
	    	int min=0;
		    int max=10000;
		    int id = (int)Math.floor(Math.random()*(max-min+1)+min); 
	        String fname ="najat";
	        String lname ="salim";
	        String  birthdate ="1996-06-08";
	        
	        // Inserting data in database
            String q1 = "insert into students values('" +id+ "', '" +(fname+i)+
                                  "', '" +(lname+i)+ "', '" +birthdate+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             DriverManager.registerDriver(driver);

             con = DriverManager.getConnection(url, user, pass);
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
    
    public static void topTenStudents(int top10Students) {
    	
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
				 String sql = "SELECT * FROM students";
				 ResultSet rs = st.executeQuery(sql);  //ResultSet class import from library
				 
				while (rs.next() && count < top10Students) {
					int id = rs.getInt("id");
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					Date birthdate = rs.getDate("birthdate");
					
					System.out.println(id + " " + fname+ " " + lname +" " + birthdate + " ");
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
		System.out.println("School system sql (Student) :");
		System.out.println("Menu:");
		System.out.println("1- Create students table.");
		System.out.println("2- Add fake students. exp:(100)");
		System.out.println("3- Select top 10 students.");
		System.out.println("4- Exit.");
		System.out.println("*******************************");
		System.out.println("enter a number from menu above:");
		int option=in.nextInt();
		
		switch(option) {
		case 1:{
		  isStudentsTableCreated();
		  System.out.println("*******************************");
		break;
		}case 2:{
	      addFakeStudents(100);
	      System.out.println("*******************************");
		break;
		}case 3:{
		  topTenStudents(10);
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
