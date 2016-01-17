package com.sainsburys.scanner;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsburys.scanner.model.Product;
import com.sainsburys.scanner.model.Results;
import com.sainsburys.scanner.service.ProductService;
import com.sainsburys.scanner.util.JsonUtils;
import com.sainsburys.scanner.util.ScannerUtils;

/**
 * HTML Scanner to trawl through url and gather list of items
 */
public class HTMLProductScanner implements ProductScanner {
	
		
	public String scrape(String url) throws Exception {
		Results result = createEmptyResults();

		// get the html document
		Document doc = ScannerUtils.getHTMLDocument(url).parse();

		// iterate over the elements and get the product details
		getProducts(result, getSummaryElements(doc));

		return JsonUtils.getJsonString(result);
	}

	
	/**
	 * Get elements from the summary page
	 * @param doc
	 * @return
	 */
	private Elements getSummaryElements(Document doc)
	{
		Elements products = doc.getElementsByClass("productLister").select("li");
		return products;
	}

	
	/**
	 * Build up the product details
	 * 
	 * @param result
	 * @param products
	 * @throws Exception
	 */
	private static void getProducts(final Results result, final Elements products) throws Exception {
		BigDecimal amount = new BigDecimal(0);

		// iterate over the elements and get the product details
		for (Element htmlproduct : products) {

			Element link = htmlproduct.getElementsByClass("productInfo").select("a[href]").first();
			String productUrl = link.attr("abs:href");

			// get the product details and add it to the list
			Product product = ProductService.getIndividualProducts(productUrl);
			result.getProducts().add(product);
			amount = amount.add(BigDecimal.valueOf(product.getUnitPrice()));

		}
		result.setTotal(amount.doubleValue());
	}

	/**
	 * Create empty result template
	 * 
	 * @return
	 */
	private Results createEmptyResults() {
		Results result = new Results();
		List<Product> productsList = new LinkedList<Product>();
		result.setProducts(productsList);
		return result;
	}

}
