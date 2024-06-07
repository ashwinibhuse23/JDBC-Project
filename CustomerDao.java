package example.jdbc.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.entity.Customer;
import example.jdbc.utils.JdbcUtils;

public class CustomerDao implements DaoInterface<Customer, Integer> {

	@Override
	public Collection<Customer> retrieveAll() {
		//creating an empty Collection of Customers
		Collection<Customer> allCustomers = new ArrayList<>();
		//some code to get data from database and fill that 
		//into this colletion 
		String sqlQuery=" select cname,address,custid from customer";
		
		try (
				Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs= stmt.executeQuery(sqlQuery);

		){
			
			 while(rs.next()) {
				 String name = rs.getString(1);
				 String address = rs.getString(2);
				 int id = rs.getInt(3);
				 Customer currentCustomer=new Customer(id,name,address);
				 allCustomers.add(currentCustomer);
			 }
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCustomers;
	}

	@Override
	public Customer retriveOne(Integer id) {
		// Fetching single customer ID and returning it 
		Customer foundCustomer=null;
		String sqlQuery=" select cname,address,custid from customer where custid=?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()) {//if customer exists
				 String name = rs.getString(1);
				 String address = rs.getString(2);
				 int cust_id = rs.getInt(3); 
				 foundCustomer = new Customer(cust_id,name,address);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundCustomer;
	}

	@Override
	public void create(Customer customerRef) {
		String sqlQuery="insert into customer values(?,?,?)";
		try(
			Connection dbConnection = JdbcUtils.buildConnection()
;
				PreparedStatement pstmt=dbConnection.prepareStatement(sqlQuery);
				){
			
		
		int custId=customerRef.getCustomerId();
		String custname= customerRef.getName();
		String custAddress=customerRef.getAddress();
		pstmt.setInt(1,custId);
		pstmt.setString(2,custname);
		pstmt.setString(3,custAddress);
		
		int updateCount=pstmt.executeUpdate();
		System.out.println(updateCount+" record inserted");
	}
	catch(Exception ex) {
		ex.printStackTrace();
		
		
	}
	}

	@Override
	public void delete(Integer id) {
	String sqlQuery= "delete from customer where custid=?";
	try(
		Connection dbConnection = JdbcUtils.buildConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			){
		pstmt.setInt(1, id);
		int updateCount= pstmt.executeUpdate();
		System.out.println(updateCount+" record delted");
}
	catch(Exception ex) {
		ex.printStackTrace();
	}
		
	}

	@Override
	public void update(Customer modifiedCustomer) {
		String sqlQuery="update customer set cname=?, address=? where custid=?";
		int id = modifiedCustomer.getCustomerId();
		String newName= modifiedCustomer.getName();
		String newAddress= modifiedCustomer.getAddress();
		
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt=dbConnection.prepareStatement(sqlQuery);
				){
			pstmt.setString(1,newName);
			pstmt.setString(2,newAddress);
			pstmt.setInt(3, id);
			
			int updateCount=pstmt.executeUpdate();
			System.out.println(updateCount+"record updated");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
}


				 
			
		
			
		
		
		
	
	
	
	


