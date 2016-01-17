package com.sainsburys.scanner.model;

import com.google.gson.annotations.SerializedName;

public class Product  {

	    @SerializedName("title")
	    private String productName;

	    @SerializedName("size")
	    private String pageSize;

	    @SerializedName("unit_price")
	    private Double unitPrice;

	    @SerializedName("description")
	    private String productDescription;

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }	  

	    public String getPageSize() {
			return pageSize;
		}

		public void setPageSize(String pageSize) {
			this.pageSize = pageSize;
		}

		public Double getUnitPrice() {
	        return unitPrice;
	    }

	    public void setUnitPrice(Double unitPrice) {
	        this.unitPrice = unitPrice;
	    }

	    public String getProductDescription() {
	        return productDescription;
	    }

	    public void setProductDescription(String productDescription) {
	        this.productDescription = productDescription;
	    }

		@Override
		public String toString() {
			return "Product [productName=" + productName + ", pageSize=" + pageSize + ", unitPrice=" + unitPrice
					+ ", productDescription=" + productDescription + "]";
		}

			    
}
