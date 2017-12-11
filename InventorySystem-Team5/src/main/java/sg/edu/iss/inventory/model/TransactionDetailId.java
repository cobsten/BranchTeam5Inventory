package sg.edu.iss.inventory.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionDetailId implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "transactionId")
	private int transactionId;
	@Column(name = "partNo")
	private String partNo;
	public TransactionDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDetailId(int transactionId, String partNo) {
		super();
		this.transactionId = transactionId;
		this.partNo = partNo;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
