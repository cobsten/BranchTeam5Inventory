package sg.edu.iss.inventory.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
	@Column(name = "supplierId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	@Column(name = "supplierName")
	private String supplierName;
	@Column(name = "supplierContactNo")
	private String supplierContactNo;
	@OneToMany(mappedBy="supplier")
	private List<Order> suppliers;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int supplierId, String supplierName, String supplierContactNo, List<Order> suppliers) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierContactNo = supplierContactNo;
		this.suppliers.addAll(suppliers);
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierContactNo() {
		return supplierContactNo;
	}
	public void setSupplierContactNo(String supplierContactNo) {
		this.supplierContactNo = supplierContactNo;
	}
	public List<Order> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Order> suppliers) {
		this.suppliers.addAll(suppliers);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + supplierId;
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
		Supplier other = (Supplier) obj;
		if (supplierId != other.supplierId)
			return false;
		return true;
	}
	
	
}
