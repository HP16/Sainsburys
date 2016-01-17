package com.sainsburys.scanner;



import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sainsburys.scanner.model.Product;
import com.sainsburys.scanner.service.ProductService;
import com.sainsburys.scanner.util.JsonUtils;
import com.sainsburys.scanner.util.ScannerUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ProductService.class, JsonUtils.class ,HTMLProductScanner.class, ScannerUtils.class})
public class HTMLProductScannerTest {

	@Mock
	private Product productA;

	@Mock
	private Product productB;

	@Mock
	private Document mockDoc;

	@Mock
	private Connection.Response response;
	
	private HTMLProductScanner scanner;
	@Mock
	private Elements mockElement;

	@Before
	public void setUp() throws Exception {
		scanner = PowerMockito.spy(new HTMLProductScanner());
		response = PowerMockito.mock(Connection.Response.class);
		mockElement = PowerMockito.mock(Elements.class);
		mockDoc = PowerMockito.mock(Document.class);
		
		productA = new Product();
		productA.setPageSize("24kb");
		productA.setProductName("Test Product");
		mockDoc.attr("productLister","test" );       
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getIndividualProductsTest() throws Exception {

		PowerMockito.mockStatic(ScannerUtils.class);
		PowerMockito.mockStatic(ProductService.class);		
	
		PowerMockito.when(ScannerUtils.getHTMLDocument("http://test.com").parse()).thenReturn(mockDoc);
		PowerMockito.when(ProductService.getProductName(mockDoc)).thenReturn("Test Product");
		PowerMockito.when(ProductService.getIndividualProducts("http://test.com")).thenReturn(
				productA);
		
		scanner.scrape("http://test.com");
	}
	
	

}
