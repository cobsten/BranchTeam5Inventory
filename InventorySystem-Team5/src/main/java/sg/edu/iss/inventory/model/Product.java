package sg.edu.iss.inventory.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "partNo")
	String partNo;
	@Basic(optional = false)
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

	public Product() {

	}

	public Product(String partNo, String carDealer, String partDescription, int availableQty, String color,
			String dimension, int reorderLevel, String shelfLocation, String productStatus) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableQty;
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
		if (availableQty != other.availableQty)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [partNo=" + partNo + ", carDealer=" + carDealer + ", partDescription=" + partDescription
				+ ", availableQty=" + availableQty + ", color=" + color + ", dimension=" + dimension + ", reorderLevel="
				+ reorderLevel + ", shelfLocation=" + shelfLocation + ", productStatus=" + productStatus + "]";
	}

}
