package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "partNo")
	String partNo;
	
	@Column(name = "OrderId")
	int orderId;

	public OrderDetailId() {
		super();
	}
	public OrderDetailId(String partNo, int orderId) {
		this.partNo=partNo;
		this.orderId=orderId;
	}
	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
