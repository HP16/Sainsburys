package com.sainsburys.scanner.service;

import static org.junit.Assert.*;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sainsburys.scanner.model.Product;
import com.sainsburys.scanner.util.JsonUtils;
import com.sainsburys.scanner.util.ScannerUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ProductService.class, JsonUtils.class })
public class ProductServiceTest {

	@Mock
	private Product productA;

	@Mock
	private Product productB;

	@Mock
	private Document mockDoc;

	@Mock
	private Connection.Response response;

	@Before
	public void setUp() throws Exception {
		response = Mockito.mock(Connection.Response.class);
		productA = new Product();
		productA.setPageSize("24kb");
		productA.setProductName("Test Product");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getIndividualProductsTest() throws Exception {

		PowerMockito.mockStatic(ScannerUtils.class);
		PowerMockito.mockStatic(ProductService.class);

		PowerMockito.when(ProductService.getIndividualProducts("http://test.com")).thenReturn(
				productA);

		Product actualResult = ProductService.getIndividualProducts("http://test.com");

		assertEquals(actualResult, productA);
	}
	
	

}
