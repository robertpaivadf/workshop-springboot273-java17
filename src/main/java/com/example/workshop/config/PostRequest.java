package com.example.workshop.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PostRequest {
	
	public static void executaJson2(String url, String json ) throws Exception {
		
			String charset = "UTF-8";
			String sToken = "Token123$";
			HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .header("Content-Type", "application/json;charset=" + charset)	                
	                .header("xToken" , sToken)
	                .POST(HttpRequest.BodyPublishers.ofString(json))
	                .build();
	
	        HttpResponse<String> response = client.send(request,
	                HttpResponse.BodyHandlers.ofString());
	
	        System.out.println(response.body());
	}
			
}