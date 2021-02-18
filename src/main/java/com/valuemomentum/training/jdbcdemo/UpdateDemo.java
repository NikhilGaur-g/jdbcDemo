package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		Connection con; // creating connection object
	     PreparedStatement pstmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     int cnt = 0;
	     String sqlUpdate;
	     try {
	    	 //Register jdbc driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 
	    	 // open a connection
	    	 System.out.println("Connecting to database");
	    	 
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	  sqlUpdate = "update candidates "+"set last_name=? "+"where id=? ";
	    	  pstmt=con.prepareStatement(sqlUpdate);
	    	  //prepare data for update
	    	  
	    	  Scanner s=new Scanner(System.in);
	    	  
	    	  System.out.println("enter employee last name:");
	    	  String lastname=s.next();
	    	  System.out.println("enter employee id:");
	    	  int eid=s.nextInt();
	    	  
	    	  pstmt.setString(1, lastname);
	    	  pstmt.setInt(2, eid);
	    	  int rowAffected=pstmt.executeUpdate();
	    	  System.out.println(String.format("row affected %d", rowAffected));
	    	  //reuse prepared statement
	    	  lastname="Grohe";
	    	  eid=101;
	    	  pstmt.setString(1, lastname);
	    	  pstmt.setInt(2, eid);
	    	  rowAffected=pstmt.executeUpdate();
	    	  System.out.println(String.format("row affected %d", rowAffected));
	    	  con.close();
	    	  
	 

	}
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }

}
}
