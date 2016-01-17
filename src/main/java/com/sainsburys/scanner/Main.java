package com.sainsburys.scanner;


public class Main {

	/**
	 * example URL:
	 * http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
		
		if (args.length == 1) {
			url = args[0];
		}
		
		//call scanner with arg
		ProductScanner htmlScanner = new HTMLProductScanner();
		System.out.println(htmlScanner.scrape(url));
			

	}

}
