package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class DeleteCustomerExampleMain {
	
	public static void main(String[]args) {
		DaoInterface<Customer,Integer>daoRef=new CustomerDao();
		daoRef.delete(2);
	}

}
