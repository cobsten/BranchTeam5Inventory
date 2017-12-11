package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderdetail")
public class OrderDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderDetailId id;
//	@Id
//	@Column(name="orderId")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int orderId;
//	@Id
//	@Column(name="partNo")
//	private String partNo;
	@Column(name="transactionQty")
	private int transactionQty;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(OrderDetailId id, int transactionQty) {
		super();
		this.id=id;
		this.transactionQty = transactionQty;
	}
	
	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public int getTransactionQty() {
		return transactionQty;
	}

	public void setTransactionQty(int transactionQty) {
		this.transactionQty = transactionQty;
	}

}
