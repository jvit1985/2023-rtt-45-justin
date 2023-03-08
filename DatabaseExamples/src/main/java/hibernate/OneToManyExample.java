package hibernate;

import java.util.Date;

public class OneToManyExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		
		Employee e = employeeDao.findById(1166);
		System.out.println(e);
		
		for (Customer customer: e.getCustomers() ) {
			System.out.println(customer);
		}
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer");
		customer.setContactFirstName("First Name");
		customer.setContactLastName("Last Name");
		customer.setPhone("555-555-1212");
		customer.setAddressLine1("123 Main Street");
		customer.setCity("Some City");
		customer.setState("TX");
		customer.setCountry("USA");
		customer.setEmployee(e);
		
		customerDao.insert(customer);
		
		e.getCustomers().add(customer);
		employeeDao.update(e);
		
		Customer c = customerDao.findById(103);
		System.out.println(c);
		
		for (Payment payment: c.getPayments() ) {
			System.out.println(payment);
		}
		
		Payment payment = new Payment();
		payment.setCheckNumber("AB123456");
		payment.setAmount(1500.23);
		payment.setPaymentDate(new Date());
		payment.setCustomer(c);
		
		customer.getPayments().add(payment);
		customerDao.update(customer);
		
	}

}
