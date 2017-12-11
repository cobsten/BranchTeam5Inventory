package sg.edu.iss.inventory.service;

import java.util.ArrayList;

import sg.edu.iss.inventory.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProduct();

	Product findProducts(String productNo);

	Product createProduct(Product product);

	Product changeProduct(Product product);

	void removeProduct(Product product);

	ArrayList<Product> searchProduct(Product product);
	
	ArrayList<Product> searchAllCarDealer();
	
	ArrayList<Product> searchAllPartDescription();	

	ArrayList<Product> searchAllColor();

}