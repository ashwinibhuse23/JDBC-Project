package example.jdbc;

import example.jdbc.dao.CustomerDao;
import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;

public class UpdateCustomerExampleMain {

	public static void main(String[] args) {
		DaoInterface<Customer,Integer>daoRef=new CustomerDao();
		Customer customerRef= daoRef.retriveOne(1);
		customerRef.setName("chetana patil");
		customerRef.setAddress("nashik");
		daoRef.update(customerRef);

	}

}
