package com.jbk.Nipmap_Api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbk.Nipmap_Api.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
}
