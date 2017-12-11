package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transactiondetail")
public class TransactionDetail implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionDetailId id;
	
	@Column(name = "transactionQty")
	private int transactionQty;

	public TransactionDetail() {
		super();
	}

	public TransactionDetail(TransactionDetailId id, int transactionQty) {
		super();
		this.id = id;
		this.transactionQty = transactionQty;
	}

	public TransactionDetailId getId() {
		return id;
	}

	public void setId(TransactionDetailId id) {
		this.id = id;
	}

	public int getTransactionQty() {
		return transactionQty;
	}

	public void setTransactionQty(int transactionQty) {
		this.transactionQty = transactionQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDetail other = (TransactionDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
