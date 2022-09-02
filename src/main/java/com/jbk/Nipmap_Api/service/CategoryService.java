package com.jbk.Nipmap_Api.service;

import java.util.List;

import com.jbk.Nipmap_Api.entity.Category;

public interface CategoryService {
	
	List<Category> getAllCategories(Integer pageNo, Integer pagesize);
	Category addNewCategory(Category category);
	Category getCategoryById(int id);
	Category updateCategoryById(int id,Category category);
	boolean deleteCategoryById(int id);

	
	

}
