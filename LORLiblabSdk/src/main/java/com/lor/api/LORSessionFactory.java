/**
 * 
 */
/**
 * @author Mahesh Gajapathy
 *
 */
package com.lor.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Common Factory class for all sessions of Lord Of the Rings API.
 */

public abstract class LORSessionFactory {
	public static final String MOVIE_API_URL = "API_URL";
	public static final String API_KEY = "API_KEY";
	public static LORMovieInstance lorInstance;
	private static String LOR_API_EXCEPTION = "API_EXCEPTION";
	public static InputStream responseStream;
	
	public static LORMovieInstance getMovieInstance(HashMap<String, String> params) throws APIException {
		try {
			String inputurl = params.get(MOVIE_API_URL);
			String key = params.get(API_KEY);
			
			
			// Using URI as URL(String) is deprecated in Java 20
			URI uri = new URI(inputurl);
			URL url = uri.toURL();

			// Open a connection on the URL and cast the response
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Now it's "open", we can set the request method, headers etc.
			// In this case connection.setRequestProperty("Authorization", "One API Key");
			
			connection.setRequestProperty("Authorization", "Bearer CbUiABAIhoCZqeBJLEVR");

			// This line makes the request
			responseStream = connection.getInputStream();
			
			// Manually converting the response body InputStream to LORMovieInstance using Jackson Library
	        ObjectMapper mapper = new ObjectMapper();
	        lorInstance = mapper.readValue(responseStream, LORMovieInstance.class);
	        
	       
		}
		catch(IOException ex){
			System.out.println("IOException = " + ex.toString());
			throw new APIException(LOR_API_EXCEPTION, "Failed to connect API", ex);
		} catch (URISyntaxException ex) {
			System.out.println("URISyntaxException = " + ex.toString());
			throw new APIException(LOR_API_EXCEPTION, "Failed to connect API - Check the URL", ex);
		}
		catch(Exception ex) {
			throw new APIException(LOR_API_EXCEPTION, "Failed to connect API", ex);
		}
		finally {
			if(responseStream != null) {
				try {
					responseStream.close();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					throw new APIException(LOR_API_EXCEPTION, "Failed to connect API", ex);
				}
			}
		}
		
		return lorInstance;
		
		
		
	}
	
}