package hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="orderdetails")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="order_id", insertable=false, updatable=false)
	private Integer orderId;
	
	@Column(name="product_id", insertable=false, updatable=false)
	private Integer productId;
	
	@Column(name="order_line_number", columnDefinition="smallint")
	private Integer orderLineNumber;
	
	@Column(name="price_each", columnDefinition="decimal", precision=10, scale=2)
	private Double priceEach;
	
	@Column(name="quantity_ordered")
	private Integer quantityOrdered;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
