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

import com.jbk.Nipmap_Api.entity.Category;
import com.jbk.Nipmap_Api.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	
	@GetMapping()
	public ResponseEntity<List<Category>> getCategorylist(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize){
		List<Category> list = cservice.getAllCategories(pageNo, pageSize);
		if(!list.isEmpty()) {
			return new  ResponseEntity<List<Category>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Category>>(list, HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category ct = cservice.addNewCategory(category);
		if(ct!=null) {
			return new ResponseEntity<Category>(ct , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Category>(ct, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable int id){
		Category ct = cservice.getCategoryById(id);
		if(ct!=null) {
			return new ResponseEntity<Category>(ct,HttpStatus.OK );
		}
		else {
			return new ResponseEntity<Category>(ct, HttpStatus.NO_CONTENT);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
		Category ct = cservice.updateCategoryById(id, category);
		if(ct!=null) {
			return new ResponseEntity<Category>(ct, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Category>(ct, HttpStatus.NO_CONTENT);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		boolean b = cservice.deleteCategoryById(id);	
		if(b) {
			return new ResponseEntity<String>("Category deleted succefully", HttpStatus.OK);
		}
		else {
			return new  ResponseEntity<String>("category not found !!!", HttpStatus.NO_CONTENT);
		}
	}
}
