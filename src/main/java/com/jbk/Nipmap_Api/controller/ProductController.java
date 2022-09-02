package com.jbk.Nipmap_Api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Nipmap_Api.entity.Product;
import com.jbk.Nipmap_Api.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping()
	public ResponseEntity<List<Product>> getProductlist(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize){
		List<Product> list = service.getAllProduct(pageNo, pageSize);
		if(!list.isEmpty()) {
			return new  ResponseEntity<List<Product>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product p = service.addNewProduct(product);
		if(p!=null) {
			return new ResponseEntity<Product>(p , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id){
		Product p = service.getProductById(id);
		if(p!=null) {
			return new ResponseEntity<Product>(p,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<Product>(p, HttpStatus.NO_CONTENT);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
		Product p = service.updateProductById(product);
		if(p!=null) {
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(p, HttpStatus.NO_CONTENT);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		boolean b = service.deleteProductById(id);	
		if(b) {
			return new ResponseEntity<String>("Product deleted succefully", HttpStatus.OK);
		}
		else {
			return new  ResponseEntity<String>("Product not found !!!", HttpStatus.NO_CONTENT);
		}
	}

}
