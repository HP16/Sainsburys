package com.sainsburys.scanner.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsburys.scanner.model.Product;

public class JsonUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getJsonStringTest() {
		String jsonOutput = "{\"title\":\"Test Product\",\"size\":\"100kb\"}";
		
		Product p = new Product();
		p.setPageSize("100kb");
		p.setProductName("Test Product");
		
		
		assertEquals(jsonOutput, JsonUtils.getJsonString(p));
		
	}

}
