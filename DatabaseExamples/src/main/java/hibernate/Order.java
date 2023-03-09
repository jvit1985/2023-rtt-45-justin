package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="customer_id", insertable=false, updatable=false)
	private Integer customerId;
	
	@Column(name="order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name="required_date")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;
	
	@Column(name="shipped_date")
	@Temporal(TemporalType.DATE)
	private Date shippedDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="comments", columnDefinition = "TEXT")
	private String comments;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
	
	@ToString.Exclude
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

}
