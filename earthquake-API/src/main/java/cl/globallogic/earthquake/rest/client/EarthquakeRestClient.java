package cl.globallogic.earthquake.rest.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.globallogic.earthquake.model.Response;

@Component
public class EarthquakeRestClient {
	
	private String magnitudeURL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=%s&maxmagnitude=%s";
	private String dateURL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=%s&endtime=%s";

	
	public Response getEarthQuakesByMagnitude(double minMagnitude, double maxMagnitude) {
		
	RestTemplate restTemplate = new RestTemplate();
	Response response = new Response();

	try {
		System.out.println("Url: " + String.format(magnitudeURL,minMagnitude,maxMagnitude));
		response = restTemplate.getForObject(String.format(magnitudeURL,minMagnitude,maxMagnitude), Response.class);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return response;
	}
	
	
	
	public Response getEarthQuakesByDate(String startTime, String endTime) {
		
	RestTemplate restTemplate = new RestTemplate();
	Response response = new Response();

	try {
		response = restTemplate.getForObject(String.format(dateURL,startTime,endTime), Response.class);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return response;
	}
	
}
