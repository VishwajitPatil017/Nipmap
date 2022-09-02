package com.jbk.Nipmap_Api.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private double price;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Category category;

	public Product() {
		super();
	}

	public Product(int pid, String pname, double price, Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category = category;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, pid, pname, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && pid == other.pid && Objects.equals(pname, other.pname)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	
	
}
