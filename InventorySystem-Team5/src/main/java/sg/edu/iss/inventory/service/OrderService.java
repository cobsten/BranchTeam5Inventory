package sg.edu.iss.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;

import sg.edu.iss.inventory.exception.DuplicatePartNumException;
import sg.edu.iss.inventory.exception.MismatchPartNumException;
import sg.edu.iss.inventory.model.OrderDetail;
import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.model.ProductSupplier;

public interface OrderService {
	public HashMap<Product, ArrayList<ProductSupplier>> getToOrderMap();

	public HashMap<Product, ArrayList<ProductSupplier>> addPartToOrder(Product product,
			HashMap<Product, ArrayList<ProductSupplier>> toOrderMap) throws DuplicatePartNumException;

	public OrderDetail computeQty(Product product, ProductSupplier productSupplier) throws MismatchPartNumException;

	public HashMap<Product, OrderDetail> getAllOrderLowPrice(HashMap<Product, ArrayList<ProductSupplier>> toOrderMap)
			throws MismatchPartNumException;
}
