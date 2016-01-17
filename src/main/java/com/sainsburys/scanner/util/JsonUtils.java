package com.sainsburys.scanner.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json utils
 *
 */
public final class JsonUtils {

	
    public static String getJsonString(Object obj) {
    	
		//convert the response into json
		final Gson gson = new GsonBuilder().disableHtmlEscaping().create();		
		return gson.toJson(obj);     
    }
}
