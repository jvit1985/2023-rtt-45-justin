package hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

	public static void main(String[] args) {
		
		HibernateExample he = new HibernateExample();
		//he.insert();
		
		Customer first = he.findById(497);
		System.out.println(first.toString());
		
		first.setAddressLine2("This is an update");
		first.setPostalCode("76051");
		first.setCreditLimit(100000.35);
		
		he.updateCustomer(first);
		
		//List<Customer> firstNames = he.findByContactFirstName("Leslie");
		//for ( Customer c : firstNames) {
		//	System.out.println(c);
		//}
		
		
	}
	
	public void updateCustomer(Customer customer) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.merge(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Customer> findByContactFirstName(String name) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c where c.contactFirstName = :firstname";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("firstname", name);
		List <Customer> result = query.getResultList();

		session.close();
		
		return result;
	}
	
	public Customer findById(Integer id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Customer c where c.id = :idParam";
		TypedQuery<Customer> query = session.createQuery(hql,Customer.class);
		query.setParameter("idParam", id);
		Customer result = query.getSingleResult();

		session.close();
		
		return result;
	}
	
	public void insert() {
		
		SessionFactory factory = new    Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
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
		
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
}
