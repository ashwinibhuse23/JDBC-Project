package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class SimpleSELECTQueryExampleMain2 {

	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef=new CustomerDao();
		Collection<Customer>allCustomers=daoRef.retrieveAll();
		for(Customer cust : allCustomers) {
			System.out.println(cust);
		}
		
		

	}

}
