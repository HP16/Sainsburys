package com.sainsburys.scanner.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Results {


	@SerializedName("results")
	private List<Product> products;

	@SerializedName("total")
	private Double total;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


}
