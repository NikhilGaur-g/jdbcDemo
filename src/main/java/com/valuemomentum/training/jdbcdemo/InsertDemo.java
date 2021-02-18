package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con; // creating connection object
	     Statement stmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     int cnt = 0;
	     try {
	    	 //Register jdbc driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 
	    	 // open a connection
	    	 System.out.println("Connecting to database");
	    	 
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	 String str="Insert into skills(name)"+"values('hibernate')";
	    	 stmt=con.createStatement();
	    	 int rowcount=stmt.executeUpdate(str);
	    	 if(rowcount>0) {
	    		 System.out.println("record inserted successfully");
	    	 }
	    	 String str1="select count(id) from skills";
	    	 rs=stmt.executeQuery(str1);
	    	 while(rs.next())
	    	 {
	    		  cnt=rs.getInt(1);
	    	 }
			System.out.println("total no of records is"+ cnt);
	    	 con.close();
	   
	    

	}
	     catch(Exception e) {
	    	 System.out.println(e);
	     }

}
}