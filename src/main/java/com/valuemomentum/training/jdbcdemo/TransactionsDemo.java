package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionsDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con; // creating connection object
	    Statement stmt; // creating statement object
	    ResultSet rs; 
		 Class.forName("com.mysql.cj.jdbc.Driver");
    	 
    	 
    	 // open a connection
    	 System.out.println("Connecting to database");
    	 
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
    	 System.out.println("driver is loaded");
    	 
    	 // Execute a query
    	 //creating statement object using connection obj
    	 stmt=con.createStatement();
    	 con.setAutoCommit(false);
    	 try {
    		 int i1=stmt.executeUpdate("insert into candidate_skills values(100,3)");
        	 stmt.addBatch("update skills set name='Ruby' where id=8");
        	 stmt.addBatch("delete from candidates where id=34");
        	 con.commit();
        	 System.out.println("Transaction is success");
    		 
    	 }catch(Exception e) {
    		 try {
    			 con.rollback();
    			 System.out.println("Transaction failed");
    			 
    		 }catch(Exception ex) {
    			 System.out.println(ex);
    		 }
    	 }
    	 stmt.close();
    	 con.close();
    	 System.out.println("connection closed");

	}

}
