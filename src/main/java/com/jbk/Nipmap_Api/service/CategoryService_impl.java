package com.jbk.Nipmap_Api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jbk.Nipmap_Api.dao.CategoryDao;
import com.jbk.Nipmap_Api.dao.CategoryJpaDao;
import com.jbk.Nipmap_Api.entity.Category;

@Service
public class CategoryService_impl implements CategoryService {
	
	@Autowired
	CategoryDao dao;
	
	@Autowired
	CategoryJpaDao jDao;

	@Override
	public List<Category> getAllCategories(Integer pageNo, Integer pagesize) {
		Pageable p=PageRequest.of(pageNo,pagesize);
		Page<Category> page = jDao.findAll(p);
		return page.getContent();
	}

	@Override
	public Category addNewCategory(Category category) {
		return dao.addNewCategory(category);
	}

	@Override
	public Category getCategoryById(int id) {
		return dao.getCategoryById(id);
	}

	@Override
	public Category updateCategoryById(int id, Category category) {
		return dao.updateCategoryById(id, category);
	}

	@Override
	public boolean deleteCategoryById(int id) {
		return dao.deleteCategoryById(id);
	}

}
