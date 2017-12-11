package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.edu.iss.inventory.exception.DuplicatePartNumException;
import sg.edu.iss.inventory.exception.MismatchPartNumException;
import sg.edu.iss.inventory.model.OrderCartItem;
import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.model.ProductSupplier;
import sg.edu.iss.inventory.repository.OrderRepository;
import sg.edu.iss.inventory.repository.ProductRepository;
import sg.edu.iss.inventory.repository.ProductSupplierRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderRepository orderRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private ProductSupplierRepository productSupplierRepository;

	@Override
	@Transactional
	public ArrayList<OrderCartItem> createToOrderList() throws MismatchPartNumException {
		ArrayList<OrderCartItem> orderList = new ArrayList<OrderCartItem>();
		ArrayList<Product> prodList = productRepository.findProductsToReorder();
		if (!prodList.isEmpty()) {
			for (Product x : prodList) {
				ArrayList<ProductSupplier> psList = productSupplierRepository
						.findProductSupplierByProductId(x.getPartNo());
				if (!psList.isEmpty()) {
					OrderCartItem orderCartItem = new OrderCartItem(x, psList, 0);
					orderCartItem.setQuantity(qtyLowUnitPrice(orderCartItem));
					orderList.add(orderCartItem);
				}
			}
		}
		return orderList;
	}
	@Override
	@Transactional
	public void addListItem(String partNum, ArrayList<OrderCartItem> orderList)throws DuplicatePartNumException,MismatchPartNumException{
		Product product = productRepository.findProductByPartNo(partNum);
		for(OrderCartItem x:orderList) {
			if(x.getProduct().getPartNo().equalsIgnoreCase(product.getPartNo())) {
				throw new DuplicatePartNumException();
			}
			else {
				ArrayList<ProductSupplier> psList = productSupplierRepository.findProductSupplierByProductId(product.getPartNo());
				OrderCartItem orderCartItem = new OrderCartItem(product,psList,0);
				orderCartItem.setQuantity(qtyLowUnitPrice(orderCartItem));
				orderList.add(orderCartItem);
			}
		}
		return;
	}
	@Override
	@Transactional
	public void removeListItem(String partNum, ArrayList<OrderCartItem> orderList) {
		for(OrderCartItem orderCartItem:orderList) {
			if(orderCartItem.getProduct().getPartNo().equalsIgnoreCase(partNum)) {
				orderList.remove(orderCartItem);
			}
		}
		return;
	}
	
	@Override
	@Transactional
	public int qtyLowUnitPrice(OrderCartItem orderCartItem) throws MismatchPartNumException {
		ProductSupplier prodSup = null;
		int qty=0;
		if (orderCartItem.getProdSupList().isEmpty()) {throw new MismatchPartNumException();}
		else {
			for (ProductSupplier ps : orderCartItem.getProdSupList()) {
				if (prodSup == null || prodSup.getUnitPrice() > ps.getUnitPrice()) {
					prodSup = ps;
				}
			}
			qty=computeQty(orderCartItem.getProduct(), prodSup);
		}
		return qty;
		
	}
	
	@Override
	@Transactional
	public int computeQty(Product product, ProductSupplier ps) throws MismatchPartNumException {
		// TODO Auto-generated method stub
		// for Cheapest
		int toOrderQty = 0;
		if (!product.getPartNo().equalsIgnoreCase(ps.getPartNo())) {
			throw new MismatchPartNumException();
		}
		if (product.getAvailableQty() < product.getReorderLevel()) {
			if ((ps.getMinimumReorderQty() + product.getAvailableQty()) > product.getReorderLevel()) {
				toOrderQty = ps.getMinimumReorderQty() + product.getAvailableQty();
			} else {
				toOrderQty = product.getReorderLevel() - product.getAvailableQty() + 1;
			}
		}
		return toOrderQty;
	}
}
