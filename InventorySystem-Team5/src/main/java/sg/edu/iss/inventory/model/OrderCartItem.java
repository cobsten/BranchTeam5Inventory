package sg.edu.iss.inventory.model;

import java.util.ArrayList;

public class OrderCartItem {
	Product product;
	ArrayList<ProductSupplier> prodSupList;
	Integer selectedSupplierId;
	int quantity;

	public OrderCartItem() {
		super();
	}

	public OrderCartItem(Product product, ArrayList<ProductSupplier> prodSupList, Integer selectedSupplierId,
			int quantity) {
		this.product = product;
		this.prodSupList = prodSupList;
		this.selectedSupplierId = selectedSupplierId;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ArrayList<ProductSupplier> getProdSupList() {
		return prodSupList;
	}

	public void setProdSupList(ArrayList<ProductSupplier> prodSupList) {
		this.prodSupList = prodSupList;
	}

	public Integer getSelectedSupplierId() {
		return selectedSupplierId;
	}

	public void setSelectedSupplierId(Integer selectedSupplierId) {
		this.selectedSupplierId = selectedSupplierId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
