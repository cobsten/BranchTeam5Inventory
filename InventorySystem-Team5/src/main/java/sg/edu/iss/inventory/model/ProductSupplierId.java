package sg.edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductSupplierId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "partNo")
    String partNo;
	
	@Column(name = "supplierId")
    Integer supplierId;
      
      
	public ProductSupplierId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
      
      
}
