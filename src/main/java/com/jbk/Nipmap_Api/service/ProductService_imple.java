package com.jbk.Nipmap_Api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jbk.Nipmap_Api.dao.ProductDao;
import com.jbk.Nipmap_Api.entity.Product;

@Service
public class ProductService_imple implements ProductService{
	
	@Autowired
	ProductDao dao;

	@Override
	public List<Product> getAllProduct(Integer pageNo, Integer pagesize) {
		Pageable page= PageRequest.of(pageNo, pagesize);
		Page<Product> productpage = dao.findAll(page);
		return productpage.getContent();
	}

	@Override
	public Product addNewProduct(Product product) {
		return dao.save(product);
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> op = dao.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Product updateProductById(Product product) {
		Optional<Product> op = dao.findById(product.getPid());
		if(op.isPresent()) {
			Product p = dao.save(product);
			return p;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteProductById(int id) {
		Optional<Product> op = dao.findById(id);
		if(op.isPresent()) {
			dao.delete(op.get());
			return true;
		}
		else {
			return false;
		}
	}

}
