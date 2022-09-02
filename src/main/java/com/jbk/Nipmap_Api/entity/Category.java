package com.jbk.Nipmap_Api.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String categoryName;
	
	public Category(int cid, String categoryName) {
		super();
		this.cid = cid;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", categoryName=" + categoryName + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(categoryName, cid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName) && cid == other.cid;
	}
	
	
	
	
}
