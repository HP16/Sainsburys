package com.sainsburys.scanner.util;

import java.io.IOException;
import java.text.DecimalFormat;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class ScannerUtils {

	/**
	 * Return HTML response
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static Response getHTMLDocument(String url) throws IOException {
		Response resp = Jsoup.connect(url).execute();
		return resp;
	}

	/**
	 * Get page size in KB
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String getPageSizeinKB(int bytes) throws Exception {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(bytes / 1024.0) + "kb";
	}

}
