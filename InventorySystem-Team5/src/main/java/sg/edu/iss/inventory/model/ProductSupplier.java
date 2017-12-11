package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="ProductSupplier")
@Table(name = "productsupplier")
public class ProductSupplier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProductSupplierId id;
	
	@Column(name = "unitPrice")
	private double unitPrice;
	@Column(name = "minimumReorderQty")
	private int minimumReorderQty;

	public ProductSupplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSupplier(ProductSupplierId id, double unitPrice, int minimumReorderQty) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.minimumReorderQty = minimumReorderQty;
	}

	public ProductSupplierId getId() {
		return id;
	}

	public void setId(ProductSupplierId id) {
		this.id = id;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getMinimumReorderQty() {
		return minimumReorderQty;
	}

	public void setMinimumReorderQty(int minimumReorderQty) {
		this.minimumReorderQty = minimumReorderQty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		ProductSupplier other = (ProductSupplier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}


}
