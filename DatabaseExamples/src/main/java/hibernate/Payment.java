//package hibernate;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Query;
//import javax.persistence.Table;
//import javax.persistence.TypedQuery;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//@Entity
//@Table(name="payments")
//public class Payment {
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(name = "id")
//		private Integer id;
//		
//		@Column(name="customer_id", insertable=false, updatable=false)
//		private Integer customerId;
//		
//		@Column(name="check_number")
//		private String checkNumber;
//		
//		@Column(name="payment_date")
//		private String paymentDate;
//		
//		@Column(name="amount", columnDefinition="decimal", precision=10, scale=2)
//		private Double amount;
//		
//		@ManyToOne(fetch = FetchType.EAGER, optional = true)
//	    @JoinColumn(name = "customer_id", nullable = true)
//	    private Customer customer;
//		
//		
//
//		@Override
//		public String toString() {
//			return "Payment [id=" + id + ", customerId=" + customerId + ", checkNumber=" + checkNumber
//					+ ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
//		}
//
//		public Integer getId() {
//			return id;
//		}
//
//		public void setId(Integer id) {
//			this.id = id;
//		}
//
//		public Integer getCustomerId() {
//			return customerId;
//		}
//
//		public void setCustomerId(Integer customerId) {
//			this.customerId = customerId;
//		}
//
//		public String getCheckNumber() {
//			return checkNumber;
//		}
//
//		public void setCheckNumber(String checkNumber) {
//			this.checkNumber = checkNumber;
//		}
//
//		public String getPaymentDate() {
//			return paymentDate;
//		}
//
//		public void setPaymentDate(String paymentDate) {
//			this.paymentDate = paymentDate;
//		}
//
//		public Double getAmount() {
//			return amount;
//		}
//
//		public void setAmount(Double amount) {
//			this.amount = amount;
//		}
//
//		public Customer getCustomer() {
//			return customer;
//		}
//
//		public void setCustomer(Customer customer) {
//			this.customer = customer;
//		}
//}
