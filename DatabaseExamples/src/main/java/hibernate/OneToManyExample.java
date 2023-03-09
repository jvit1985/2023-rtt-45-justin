package hibernate;

import java.util.Date;

public class OneToManyExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		PaymentDAO paymentDao = new PaymentDAO();
		OrderDAO orderDao = new OrderDAO();
		OrderDetailDAO orderDetailDao = new OrderDetailDAO();
		ProductDAO productDao = new ProductDAO();
		
//		Employee e = employeeDao.findById(1166);
//		System.out.println(e);
//		
//		for (Customer customer: e.getCustomers() ) {
//			System.out.println(customer);
//		}
//		
//		Customer customer = new Customer();
//		customer.setCustomerName("Hibernate customer");
//		customer.setContactFirstName("First Name");
//		customer.setContactLastName("Last Name");
//		customer.setPhone("555-555-1212");
//		customer.setAddressLine1("123 Main Street");
//		customer.setCity("Some City");
//		customer.setState("TX");
//		customer.setCountry("USA");
//		customer.setEmployee(e);
//		
//		customerDao.insert(customer);
//		
//		e.getCustomers().add(customer);
//		employeeDao.update(e);
		
//		for (Payment payment: c.getPayments() ) {
//			System.out.println(payment);
//		}
//		
//		Payment payment = new Payment();
//		payment.setCheckNumber("AB123456");
//		payment.setAmount(1500.23);
//		payment.setPaymentDate(new Date());
//		payment.setCustomer(c);
//		
//		customer.getPayments().add(payment);
//		customerDao.update(customer);
		
//		Order order = new Order();
//		order.setOrderDate(new Date());
//		order.setRequiredDate(new Date());
//		order.setStatus("Test update");
//		order.setCustomer(c);
//		
//		c.getOrders().add(order);
//		customerDao.update(c);
		
		Customer c = customerDao.findById(103);
		Product p = productDao.findById(2);
		System.out.println(p);
		System.out.println(c);
		
		Order order1 = orderDao.findById(10100);
		p.setProductCode("Update Test");
		p.setProductName("Name");
		p.setBuyPrice(25.00);
		p.setMsrp(45.00);
		p.setProductScale("Big");
		p.setProductVendor("Coke");
		p.setQuantityInStock(200);
		p.setProductDescription("The best product ever made");
		
		productDao.insert(p);
		
//		OrderDetail od = new OrderDetail();
//		od.setOrderLineNumber(3);
//		od.setPriceEach(24.99);
//		od.setQuantityOrdered(5);
//		od.setOrder(order1);
//		od.setProduct(p);
		
		
		
//		for(OrderDetail od: order1.getOrderDetails()) {
//			System.out.println(od);
//		}
		
//		for (Order o : c.getOrders()) {
//			System.out.println(o);
//		}
		
	}

}
