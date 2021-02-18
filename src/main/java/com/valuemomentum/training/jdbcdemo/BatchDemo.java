package com.valuemomentum.training.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) throws Exception{
		Connection con; // creating connection object
	    Statement stmt; // creating statement object
	    ResultSet rs; 
		 Class.forName("com.mysql.cj.jdbc.Driver");
    	 
    	 
    	 // open a connection
    	 System.out.println("Connecting to database");
    	 
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
    	 
    	 // Execute a query
    	 //creating statement object using connection obj
    	 stmt=con.createStatement();
    	 //create batch
    	 stmt.addBatch("insert into candidate_skills values(100,5)");
    	 stmt.addBatch("update skills set name='Ajax' where id=3");
    	 stmt.addBatch("delete from candidates where id=80");
    	 
    	 //disable auto commit mode
    	 con.setAutoCommit(false);
    	 try {
    		 stmt.executeBatch();
    		 con.commit();
    		 System.out.println("batch is successfully executed");
    	 }
    	 catch(Exception e) {
    		 System.out.println(e);
    	 
    	 try {
    		 con.rollback();
    		 System.out.println("batch is failed");
    		 System.out.println("exception is"+e);
    	 }
    	 catch(Exception e1) {
    		 System.out.println("exception is:"+e1);
    		 
    	 }
    	 }
    	 
    	 //end of outer catch
    	 //cleanup
    	 stmt.close();
    	 con.close();

	}

}
