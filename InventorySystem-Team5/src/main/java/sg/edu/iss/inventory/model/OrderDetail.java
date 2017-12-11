package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity

@IdClass(OrderDetailId.class)
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderDetailId id;

	@Column(name = "transactionQty")
	private int transactionQty;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(OrderDetailId id, int transactionQty) {
		super();
		this.id = id;
		this.transactionQty = transactionQty;
	}

	public int getTransactionQty() {
		return transactionQty;
	}

	public void setTransactionQty(int transactionQty) {
		this.transactionQty = transactionQty;
	}

	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

}
