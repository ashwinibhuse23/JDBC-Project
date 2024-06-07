package example.jdbc.dao;
import example.jdbc.dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import example.jdbc.entity.Customer;


import example.jdbc.utils.JdbcUtils;

public class EnhanceCustomerDao extends CustomerDao{
	public Collection<Customer>retrieveAllCustomersByCityName(String cityName){
		
		Collection<Customer>allCustomerWithMatchingCityName=new ArrayList<>();
		
		
		String sqlQuery="select cname,address,custid from customer where address=?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			pstmt.setString(1, cityName);
			ResultSet rs= pstmt.executeQuery();
			
			
			 while(rs.next()) {
				 String name = rs.getString(1);
				 String address = rs.getString(2);
				 int id = rs.getInt(3);
				 Customer currentCustomer=new Customer(id,name,address);
				
				 allCustomerWithMatchingCityName.add(currentCustomer);
			 }
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCustomerWithMatchingCityName;
	}
	

}

