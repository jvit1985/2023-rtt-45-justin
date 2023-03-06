package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		
		CustomerDAO customerDao = new CustomerDAO();
		//we are not going to set the id column because hibernate/mysql will auto generate for us
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer");
		customer.setContactFirstName("First Name");
		customer.setContactLastName("Last Name");
		customer.setPhone("555-555-1212");
		customer.setAddressLine1("123 Main Street");
		customer.setCity("Some City");
		customer.setState("TX");
		customer.setCountry("USA");
		//he.insert();
		
		Customer first = customerDao.findById(103);
		System.out.println(first.toString());
		
		first.setAddressLine2("This is an update");
		first.setPostalCode("76051");
		first.setCreditLimit(100000.35);
		
		customerDao.update(first);
		//customerDao.delete(first);
		
		//List<Customer> firstNames = he.findByContactFirstName("Leslie");
		//for ( Customer c : firstNames) {
		//	System.out.println(c);
		//}
		
	}
}
	
