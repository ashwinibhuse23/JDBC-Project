package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;
import example.jdbc.dao.*;

public class CreateNewCustomerExampleMain {

public static void main(String[] args) {
		DaoInterface<Customer,Integer>daoRef=new CustomerDao();
		Customer customerobj= new Customer(7,"Sanket","Nagpur");
		daoRef.create(customerobj);

	}

}
