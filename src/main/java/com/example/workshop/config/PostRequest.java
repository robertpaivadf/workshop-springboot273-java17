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

	public static final String URL_POST = "http://localhost:8080/users";
	
	public static void executa() throws FileNotFoundException {		
		String sJson = "{\r\n"
						+ " \"name\": \"John Heberth\",\r\n"
						+ " \"email\": \"john@gmail.com\",\r\n"
						+ " \"phone\": \"9999999999\",\r\n"
						+ " \"password\": \"12345678\"\r\n"
						+ "}";		
		
		// cliente HTTP
		HttpClient client = HttpClient.newHttpClient();

			
		
		// criar a requisição
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(sJson))
				.timeout(Duration.ofSeconds(10)).uri(URI.create(URL_POST)).build();
		
		
				
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();

		System.out.println(request.bodyPublisher());
	}
	
	public static void executa2() throws IOException {		
		String command = "curl -X POST -H \"Content-Type: application/json\" -d '{\"name\": \"John Heberth\", \"email\": \"john@gmail.com\", \"phone\": \"9999999999\", \"password\": \"12345678\"}' http://localhost:8080/users";
		Process process = Runtime.getRuntime().exec(command);
		process.getInputStream();
	}
	
	public static void executaJason(String url, String json ) throws Exception{
	  String charset = "UTF-8"; 
	  URLConnection connection = new URL(url).openConnection();
	  connection.setDoOutput(true); // Triggers POST.
	  connection.setRequestProperty("Accept-Charset", charset);
	  connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);

	  try (OutputStream output = connection.getOutputStream()) {
	    output.write(json.getBytes(charset));
	  }
	  //InputStream response = connection.getInputStream();
	}
	
	
}