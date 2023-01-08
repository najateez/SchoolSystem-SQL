package com.schoolsystemsql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	public static void top100Students(int readTop100Student) {
		
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
				 
				while (rs.next() && count < readTop100Student) {
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

	public static void top50Subjects(int readTop50Subjects) {
	
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
				 
				while (rs.next() && count < readTop50Subjects) {
					int subject_id = rs.getInt("subject_id");
					String title = rs.getString("title");
					String descc = rs.getString("descc");
					float pricePerStudent = rs.getFloat("pricePerStudent");
					
					System.out.println(subject_id + " " + title+ " " + descc +" " + pricePerStudent + " ");
					count++;
				 }
				con.close();
			}catch (Exception ex) {
				System.err.println(ex);
			}
		}
	
	// the way of inserting data in database using java code
    public static void addNewStudent(int noOfArguments) {
    	
    	Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 

	     
	     for(int i=0;i<=noOfArguments;i++) {
	    	 int min=0;
	    	 int max=4000000;
			 int id =(int)Math.floor(Math.random()*(max-min+1)+min);
	        String fname ="Areen";
	        String lname ="Hamed";
	        String  birthdate ="1998-02-13";
	        
	        // Inserting data in database
            String q1 = "insert into students values('" +id+ "', '" +fname+
                                  "', '" +lname+ "', '" +birthdate+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             DriverManager.registerDriver(driver);
             
             con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();

             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println("new student inserted successfully : " + q1);
             else
                 System.out.println("insertion failed");

             con.close();
         
        } catch (Exception ex) {
             System.err.println(ex);
         }
	     }
}
    
 public static void addNewSubject(int noOfArguments) {
    	
    	Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 

	     
	     for(int i=0;i<=noOfArguments;i++) {
	    	 int min=0;
	    	 int max=3000000;
			 int Subject_id =(int)Math.floor(Math.random()*(max-min+1)+min);
	        String title ="PHP";
	        String descc ="PHP is a script language and interpreter that is freely available and used primarily on Linux Web servers";
	        float  pricePerStudent =365f;
	        
	        // Inserting data in database
            String q1 = "insert into subjects values('" +Subject_id+ "', '" +title+"', '" +descc+ "', '" +pricePerStudent+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             DriverManager.registerDriver(driver);

             con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();

             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println("new subject inserted successfully : " + q1);
             else
                 System.out.println("insertion failed");

             con.close();
             
         }catch (Exception ex) {
             System.err.println(ex);
         }
	     }
}
     
    public static void load1000000Students(long noOfArguments) {
    	
      Scanner in= new Scanner(System.in);
    	
    	String url = "jdbc:mysql://localhost:3306/schoolmgt";
		 String user = "root";
	     String pass = "10@104Ar$"; 

	     
	     for(int i=0;i<=noOfArguments;i++) {
	    	 int min=0;
			 int max=3000000;
			 int id = (int)Math.floor(Math.random()*(max-min+1)+min);
	        String fname ="Aseel";
	        String lname ="Hamed";
	        String  birthdate ="1998-02-13";
	        
	        // Inserting data in database
            String q1 = "insert into students values('" +id+ "', '" +fname+"', '" +lname+ "', '" +birthdate+ "')";
            
            Connection con = null;
            
        try {
        	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
             DriverManager.registerDriver(driver);
             
             con = DriverManager.getConnection(url, user, pass);
             // Creating a statement/query
             Statement st = con.createStatement();
             // Executing query
             int m = st.executeUpdate(q1);
             if (m >=  1)
                 System.out.println("1000000 students loaded successfully : " + q1);
             else
                 System.out.println("load student failed");

             //Closing the connections
             con.close();
         }
         catch (Exception ex) {
             System.err.println(ex);
         }
	     }
}
    
    public static void load100000Subjects(long noOfArguments) {
    
    Scanner in= new Scanner(System.in);
	
	String url = "jdbc:mysql://localhost:3306/schoolmgt";
	 String user = "root";
     String pass = "10@104Ar$"; 

     
     for(int i=0;i<=noOfArguments;i++) {
    	 int min=0;
		 int max=200000;
		 int Subject_id = (int)Math.floor(Math.random()*(max-min+1)+min);
        String title ="PHP";
        String descc ="PHP is a script language and interpreter that is freely available and used primarily on Linux Web servers";
        float  pricePerStudent =365f;
        
        String q1 = "insert into subjects values('" +Subject_id+ "', '" +title+"', '" +descc+ "', '" +pricePerStudent+ "')";
        
        Connection con = null;
        
    try {
    	 Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
         DriverManager.registerDriver(driver);

         con = DriverManager.getConnection(url, user, pass);
         Statement st = con.createStatement();

         int m = st.executeUpdate(q1);
         if (m >=  1)
             System.out.println("new subject inserted successfully : " + q1);
         else
             System.out.println("insertion failed");
         
         con.close();
         
     }catch (Exception ex) {
         System.err.println(ex);
     }
     }
}

 
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		boolean isExit=true;
		
    do {	
		System.out.println("Menu:");
		System.out.println("1:List Top 100 Students.");
		System.out.println("2:List Top 50 Subjects.");
		System.out.println("3:Add a new Student.");
		System.out.println("4:Add a new Subject.");
		System.out.println("5:Load 1000000 student in Students Table.");
		System.out.println("6:Load 100000 subjects in Subjects Table.");
		System.out.println("7:Exit App.");
		System.out.println("*******************************");
		System.out.println("Enter any number from menu above");
		int option=in.nextInt();
		
		switch(option) {
		case 1:{
			top100Students(100);
			System.out.println("*******************************");
			break;
		}case 2:{
			top50Subjects(50);
			System.out.println("*******************************");
			break;
		}case 3:{
			addNewStudent(0);
			System.out.println("*******************************");
			break;
		}case 4:{
			addNewSubject(0);
			System.out.println("*******************************");
			break;
		}case 5:{
			load1000000Students(1000000);
			System.out.println("*******************************");
			break;
		}case 6:{
			load100000Subjects(100000);
			System.out.println("*******************************");
			break;
		}case 7:{
			isExit= false;
			break;
		}default:{
			System.out.println("it is not an option, try again.");
			System.out.println("*******************************");
		}
		}
    }while(isExit);
		
		
		
		

	}

}
