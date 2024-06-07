package example.jdbc;
import example.jdbc.dao.*;
import java.util.Collection;
import example.jdbc.entity.Customer;
public class DaoEnhancementExampleMain {

	public static void main(String[] args) {
		EnhanceCustomerDao enhancedDaoRef=new EnhanceCustomerDao();
	Collection<Customer> customerWithMatchingCity=enhancedDaoRef.retrieveAllCustomersByCityName("Nashik");
	 int size = customerWithMatchingCity.size();
	 if(size!=0) {
		
		for(Customer customerRef: customerWithMatchingCity)
			 System.out.println(customerRef);
	 }
	 else {
		 System.out.println("No customer found with the city ");
	 }
	
	for(Customer customerRef : customerWithMatchingCity) {
		 System.out.println(customerRef);
	}

	}

}
