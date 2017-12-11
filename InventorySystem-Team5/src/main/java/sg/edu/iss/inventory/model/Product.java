package sg.edu.iss.inventory.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {	
	
	@Id
	@Column(name = "partNo")
	String partNo;
	@Basic
	@Column(name = "carDealer")
	String carDealer;
	@Column(name = "partDescription")
	String partDescription;
	@Column(name = "availableQty")
	int availableQty;
	@Column(name = "color")
	String color;
	@Column(name = "dimension")
	String dimension;
	@Column(name = "reorderLevel")
	int reorderLevel;
	@Column(name = "shelfLocation")
	String shelfLocation;
	@Column(name = "productStatus")
	String productStatus;
	@OneToMany(mappedBy="product")
	private List<Return> returns;
	public Product() {
		super();
	}
	public Product(String partNo, String carDealer, String partDescription, int availableQty, String color,
			String dimension, int reorderLevel, String shelfLocation, String productStatus, List<Return> returns) {
		super();
		this.partNo = partNo;
		this.carDealer = carDealer;
		this.partDescription = partDescription;
		this.availableQty = availableQty;
		this.color = color;
		this.dimension = dimension;
		this.reorderLevel = reorderLevel;
		this.shelfLocation = shelfLocation;
		this.productStatus = productStatus;
		this.returns.addAll(returns);
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getCarDealer() {
		return carDealer;
	}
	public void setCarDealer(String carDealer) {
		this.carDealer = carDealer;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public int getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public String getShelfLocation() {
		return shelfLocation;
	}
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public List<Return> getReturns() {
		return returns;
	}
	public void setReturns(List<Return> returns) {
		this.returns = returns;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partNo == null) ? 0 : partNo.hashCode());
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
		Product other = (Product) obj;
		if (partNo == null) {
			if (other.partNo != null)
				return false;
		} else if (!partNo.equals(other.partNo))
			return false;
		return true;
	}
	

	
}
