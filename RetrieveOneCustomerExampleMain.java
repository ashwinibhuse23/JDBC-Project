package retriveone;

import example.jdbc.dao.DaoInterface;
import example.jdbc.entity.Customer;
import example.jdbc.dao.*;

public class RetrieveOneCustomerExampleMain {
	public static void main(String[]args) {
		DaoInterface<Customer,Integer> daoRef=new CustomerDao();
		Customer customerRef=daoRef.retriveOne(4);
		if(customerRef !=null)
		{
			System.out.println(customerRef);
		}
		else
		{
			System.out.println("Customer with given ID does not exists");
		}
	}

}
