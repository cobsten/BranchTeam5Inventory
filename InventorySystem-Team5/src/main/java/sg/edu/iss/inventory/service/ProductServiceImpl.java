package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.inventory.model.Product;
import sg.edu.iss.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource ProductRepository productRepository;
	
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct()
	{
		ArrayList<Product> userList = (ArrayList<Product>)productRepository.findActiveProduct();
		return userList;
	}
		
	@Override
	@Transactional
	public Product findProducts(String productNo) {
		Product l = productRepository.findProductByPartNo(productNo);
		return l;
	}
	
	@Override
	@Transactional
	public Product createProduct(Product product) {
		product.setProductStatus("Valid");
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public Product changeProduct(Product product) {
		product.setProductStatus("Valid");
		return productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public void removeProduct(Product product) {
		product.setProductStatus("Invalid");
		productRepository.saveAndFlush(product);
	}

	@Override
	@Transactional
	public ArrayList<Product> searchProduct(Product product) {
		ArrayList<Product> l = new ArrayList<Product>();
		l = productRepository.serachProductByPartNo(product.getPartNo());
//		if (product.getPartNo() != null) {
//			l = productRepository.serachProductByPartNo(product.getPartNo());
//		} else if (product.getCarDealer() != null && product.getColor() != null) {
//			l = productRepository.findProductByDealerNColor(product.getColor(), product.getCarDealer());
//		} else {
//			l = productRepository.findProductByCarDealer(product.getCarDealer());
//		}
		return l;		
	}
	
	@Override
	@Transactional
	public ArrayList<Product> searchAllCarDealer()
	{
		return productRepository.findcarDealer();
	}
	
	@Override
	@Transactional
	public ArrayList<Product> searchAllPartDescription()
	{
		return productRepository.findPartDescription();
	}

	@Override
	@Transactional
	public ArrayList<Product> searchAllColor() {
		return productRepository.findColor();
	}
}
