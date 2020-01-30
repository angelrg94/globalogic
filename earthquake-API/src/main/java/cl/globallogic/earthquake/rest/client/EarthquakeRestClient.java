package cl.globallogic.earthquake.rest.client;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.jboss.logging.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.globallogic.earthquake.exception.InternalErrorException;
import cl.globallogic.earthquake.model.Feature;
import cl.globallogic.earthquake.model.Response;

/**
 * The Class EarthquakeRestClient.
 */
@Component
public class EarthquakeRestClient {
	
	/** The magnitude URL. */
	@Value("${url.magnitude}")
	private String magnitudeURL;
	
	/** The date URL. */
	@Value("${url.date}")
	private String dateURL;


	/**
	 * Gets the earth quakes by magnitude.
	 *
	 * @param minMagnitude the min magnitude
	 * @param maxMagnitude the max magnitude
	 * @return the earth quakes by magnitude
	 */
	public Response getEarthQuakesByMagnitude(double minMagnitude, double maxMagnitude) {
			
	RestTemplate restTemplate = new RestTemplate();
	Response response = new Response();
	System.out.println(String.format(magnitudeURL,minMagnitude,maxMagnitude));
	try {
		response = restTemplate.getForObject(String.format(magnitudeURL,minMagnitude,maxMagnitude), Response.class);
	}
	catch(Exception e) {
		throw new InternalErrorException(e.getMessage());
	}
	return response;
	}
	

	
	/**
	 * Gets the earth quakes by date.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the earth quakes by date
	 */
	public Response getEarthQuakesByDate(LocalDate startTime, LocalDate endTime) {
		
	RestTemplate restTemplate = new RestTemplate();
	Response response = new Response();
	
	try {
		response = restTemplate.getForObject(String.format(dateURL,startTime,endTime), Response.class);
	}
	catch(Exception e) {
		throw new InternalErrorException(e.getMessage());
	}
	return response;
	}
	
	/**
	 * Gets the earth quakes by date ranges.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param startTime2 the start time 2
	 * @param endTime2 the end time 2
	 * @return the earth quakes by date ranges
	 */
	public Response getEarthQuakesByDateRanges(LocalDate startTime, LocalDate endTime,LocalDate startTime2, LocalDate endTime2) {
		
	Response responseFinal = new Response();
	Response response = new Response();	
		
		response= getResponse(startTime, endTime);
		responseFinal.setFeatures(new ArrayList<Feature>());
		responseFinal.getFeatures().addAll(response.getFeatures());
		response= getResponse(startTime2, endTime2);
		responseFinal.getFeatures().addAll(response.getFeatures());
		responseFinal.setMetadata(response.getMetadata());
		responseFinal.getMetadata().setCount(responseFinal.getFeatures().size());

	    return responseFinal;
	    
	    
	}
	
	
	
	/**
	 * Gets the response.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the response
	 */
	public Response getResponse(LocalDate startTime, LocalDate endTime) {
		
		Response response = new Response();
		RestTemplate restTemplate = new RestTemplate();

		try {
		response= restTemplate.getForObject(String.format(dateURL,startTime,endTime), Response.class);
		
		}
		catch(Exception e) {
			throw new InternalErrorException(e.getMessage());
		}
		
		return response;
	}

}
