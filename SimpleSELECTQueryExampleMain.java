package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExampleMain {
	public static void main(String[]args) {
		
		//load the Driver
		
		//java.io.FileInputStream
		//java.util.ArraryList
		
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String driverClassName ="com.mysql.cj.jdbc.Driver";
			Class.forName(driverClassName);   
			System.out.println("Driver Loaded");
			
			
			//Establish Connection
			String URL = "jdbc:mysql://localhost:3306/cdac";
			String UID="root";
			String PWD="root";
			 dbConnection = DriverManager.getConnection(URL, UID, PWD);
			
			System.out.println("Connected.");
			
			//obtain some statement
			 stmt = dbConnection.createStatement();
			
			//Execute Sql query
			String sqlQuery=" select cname,address,custid from customer";
			
			 rs= stmt.executeQuery(sqlQuery);
			
			 //perform Navigation
			 while(rs.next()) {
				 String name = rs.getString(1);
				 String address = rs.getString(2);
				 int id = rs.getInt(3);
				 System.out.println(" ID: "+id +" , Name: "+name+" , Address: "+address);
			 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//closing all the resources
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
	}

}
