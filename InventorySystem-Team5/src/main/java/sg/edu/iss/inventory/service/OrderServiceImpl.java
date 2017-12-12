package sg.edu.iss.inventory.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.edu.iss.inventory.exception.DuplicatePartNumException;
import sg.edu.iss.inventory.exception.MismatchPartNumException;
import sg.edu.iss.inventory.model.Order;
import sg.edu.iss.inventory.model.OrderCartItem;
import sg.edu.iss.inventory.model.OrderDetail;
import sg.edu.iss.inventory.model.OrderDetailId;
import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.model.ProductSupplier;
import sg.edu.iss.inventory.model.Supplier;
import sg.edu.iss.inventory.model.User;
import sg.edu.iss.inventory.repository.OrderDetailRepository;
import sg.edu.iss.inventory.repository.OrderRepository;
import sg.edu.iss.inventory.repository.ProductRepository;
import sg.edu.iss.inventory.repository.ProductSupplierRepository;
import sg.edu.iss.inventory.repository.SupplierRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderRepository orderRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private ProductSupplierRepository productSupplierRepository;
	@Resource
	private SupplierRepository supplierRepository;
	@Resource
	private OrderDetailRepository orderDetailRepository;

	@Override
	@Transactional
	public ArrayList<OrderCartItem> createToOrderList() throws MismatchPartNumException {
		ArrayList<OrderCartItem> orderList = new ArrayList<OrderCartItem>();
		ArrayList<Product> prodList = productRepository.findReorderProduct();
		if (!prodList.isEmpty()) {
			for (Product x : prodList) {
				ArrayList<ProductSupplier> psList = productSupplierRepository
						.findProductSupplierByProductId(x.getPartNo());
				if (!psList.isEmpty()) {
					OrderCartItem orderCartItem = getLowPriceItem(x,psList);
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
				OrderCartItem orderCartItem=getLowPriceItem(product,psList);
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
	public OrderCartItem getLowPriceItem(Product product, ArrayList<ProductSupplier> prodSupList) throws MismatchPartNumException {
		ProductSupplier prodSup = null;
		int qty=0;
		if (prodSupList.isEmpty()) {throw new MismatchPartNumException();}
		else {
			for (ProductSupplier ps : prodSupList) {
				if (prodSup == null || prodSup.getUnitPrice() > ps.getUnitPrice()) {
					prodSup = ps;
				}
			}
			qty=computeQty(product, prodSup);
		}
		return new OrderCartItem(product,prodSupList,prodSup.getId().getSupplierId(),qty);
		
	}
	
	@Override
	@Transactional
	public int computeQty(Product product, ProductSupplier ps) throws MismatchPartNumException {
		// TODO Auto-generated method stub
		// for Cheapest
		int toOrderQty = 0;
		if(!product.getPartNo().equalsIgnoreCase(ps.getId().getPartNo())) {
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
	@Transactional
	public void logOrders(User user, ArrayList<OrderCartItem> orderList ) {
		HashSet<Integer> supplierList = new HashSet<Integer>();
		for(OrderCartItem x:orderList) {
			supplierList.add(x.getSelectedSupplierId());
		}
		for(Integer supplierId:supplierList) {
			Supplier supplier = supplierRepository.findSupplierBysupplierId(supplierId);
			Order order=createOrder(user,supplier);
			orderRepository.saveAndFlush(order);
			ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
			for(OrderCartItem orderCartItem:orderList) {
				if(supplierId==orderCartItem.getSelectedSupplierId()) {
					OrderDetail orderDetail = createOrderDetail(orderCartItem.getProduct().getPartNo(),order.getOrderId(),orderCartItem.getQuantity());
					orderDetailList.add(orderDetail);
				}
			}
			orderDetailRepository.save(orderDetailList);
			orderDetailRepository.flush();
		}
		return;
	}
	public Order createOrder(User userorder, Supplier supplier) {
		Date date = Calendar.getInstance().getTime();
		Order order = new Order(date,userorder,supplier);
		return order;
	}
	public OrderDetail createOrderDetail(String partNo,int orderId,int transactionQty) {
		OrderDetailId id= new OrderDetailId(partNo,orderId);
		OrderDetail orderDetail = new OrderDetail(id,transactionQty);
		return orderDetail;
	}
	
}
