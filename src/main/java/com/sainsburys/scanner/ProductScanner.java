package com.sainsburys.scanner;

public interface ProductScanner {	
		
	/**
	 * scrape through pages and return list of products
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public String scrape(String url)  throws Exception;
	
	
}
