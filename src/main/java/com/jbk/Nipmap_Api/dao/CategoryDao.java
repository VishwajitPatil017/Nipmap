package com.jbk.Nipmap_Api.dao;

import java.util.List;

import com.jbk.Nipmap_Api.entity.Category;

public interface CategoryDao {
	
	List<Category> getAllCategories();
	Category addNewCategory(Category category);
	Category getCategoryById(int id);
	Category updateCategoryById(int id, Category category);
	boolean deleteCategoryById(int id);

}
