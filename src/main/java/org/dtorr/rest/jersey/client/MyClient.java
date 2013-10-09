/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.dtorr.rest.jersey.client;


import java.net.URI;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
/**
 *
 * @author Paul
 */
public class MyClient {

    public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		// Get JSON for application
                System.out.println(MediaType.APPLICATION_JSON);
		System.out.println(service.path("rest").path("helloworld").path("1").accept(
				MediaType.APPLICATION_JSON).get(String.class));
		// Get XML for application
                System.out.println(MediaType.APPLICATION_XML);
		System.out.println(service.path("rest").path("helloworld").path("1").accept(
				MediaType.APPLICATION_XML).get(String.class));
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/jerseydemo").build();
	}

}
