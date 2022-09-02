package com.jbk.Nipmap_Api.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Nipmap_Api.entity.Category;

@Repository
public class CategoryDao_impl implements CategoryDao{
	
	@Autowired
	SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		Session session = sf.openSession();
		List<Category> list=new ArrayList<>();
		try {
			@SuppressWarnings("deprecation")
			Criteria cr = session.createCriteria(Category.class);
			list=cr.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public Category addNewCategory(Category category) {
		Session session = sf.openSession();
		try {
			Transaction tt = session.beginTransaction();
			session.save(category);
			tt.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return category;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = sf.openSession();
		Category category=new Category();
		try {
			category=session.get(Category.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return category;
	}

	@Override
	public Category updateCategoryById(int id, Category category) {
		Session session = sf.openSession();
		Category ct=new Category();
		try {
			Transaction tt = session.beginTransaction();
			ct=session.get(Category.class, id);
			if (ct!=null) {
				ct.setCategoryName(category.getCategoryName());
				session.update(ct);
				tt.commit();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return ct;
	}

	@Override
	public boolean deleteCategoryById(int id) {
		Session session = sf.openSession();
		boolean b=false;
		try {
			Transaction tt = session.beginTransaction();
			Category ct = session.get(Category.class, id);
			if (ct!=null) {
				session.delete(ct);
				tt.commit();
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return b;
	}

}
