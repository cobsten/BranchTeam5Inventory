package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import sg.edu.iss.inventory.exception.DuplicatePartNumException;
import sg.edu.iss.inventory.exception.MismatchPartNumException;
import sg.edu.iss.inventory.model.OrderCartItem;
import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.model.ProductSupplier;

public interface OrderService {

	public ArrayList<OrderCartItem> createToOrderList() throws MismatchPartNumException;

	public void addToOrderList(String partNum, ArrayList<OrderCartItem> orderList)
			throws DuplicatePartNumException, MismatchPartNumException;

	public int qtyLowUnitPrice(OrderCartItem orderCartItem) throws MismatchPartNumException;

	public int computeQty(Product product, ProductSupplier ps) throws MismatchPartNumException;
}
