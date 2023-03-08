package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		
		//Query the new payment we just created by its id
		//Change the check number and the amount
		//Update the payment
		PaymentDAO paymentDao = new PaymentDAO();
		
		Payment p = paymentDao.findById(274);
//		System.out.println(p);
		
		p.setCheckNumber("Update123");
		p.setAmount(2523.81);
		
		paymentDao.update(p);

	}

}
