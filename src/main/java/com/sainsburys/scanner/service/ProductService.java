package com.sainsburys.scanner.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sainsburys.scanner.model.Product;
import com.sainsburys.scanner.util.ScannerUtils;

/**
 * Product service to retrieve product details from a given url
 *
 */
public class ProductService  {
		
	/**
	 * get individual product details
	 * 
	 * @param products
	 * @param url
	 * @throws Exception
	 */
	public static Product getIndividualProducts(String url) throws Exception {

		Connection.Response resp = ScannerUtils.getHTMLDocument(url);
		Document doc = resp.parse();

		// create product and set values
		Product product = new Product();
		product.setProductName(getProductName(doc));
		product.setPageSize(getPageSize(resp));
		product.setProductDescription(getDescription(doc));
		product.setUnitPrice(getUnitPrice(doc));

		return product;
	}

	/**
	 * Get unit price
	 * 
	 * @param doc
	 * @return
	 */
	public static Double getUnitPrice(Document doc) {
		String price = doc.getElementsByClass("pricePerUnit").first().text().replace("£", "").replace("/unit", "");
		Double unit_price = 0.0;
		if (price != null) {
			unit_price = Double.parseDouble(price);
		}

		return unit_price;
	}

	/**
	 * Get product name from document
	 * 
	 * @param doc
	 * @return
	 */
	public static String getProductName(Document doc) {
		return Jsoup.parse(doc.getElementsByClass("productTitleDescriptionContainer").toString()).text();
	}

	/**
	 * Get page size
	 * 
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	public static String getPageSize(Connection.Response resp) throws Exception {
		return ScannerUtils.getPageSizeinKB(resp.bodyAsBytes().length);
	}

	/**
	 * Get product description
	 * 
	 * @param doc
	 * @return
	 */
	public static String getDescription(Document doc) {
		return doc.select(".productText").first().text();
	}
}
