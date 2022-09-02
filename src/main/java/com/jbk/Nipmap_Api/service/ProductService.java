package com.jbk.Nipmap_Api.service;

import java.util.List;

import com.jbk.Nipmap_Api.entity.Product;

public interface ProductService {
	
	
	List<Product> getAllProduct(Integer pageNo, Integer pagesize);
	Product addNewProduct(Product product);
	Product getProductById(int id);
	Product updateProductById(Product product);
	boolean deleteProductById(int id);

}
