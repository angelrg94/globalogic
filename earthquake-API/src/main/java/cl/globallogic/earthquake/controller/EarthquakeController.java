package cl.globallogic.earthquake.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import cl.globallogic.earthquake.model.Response;
import cl.globallogic.earthquake.rest.client.EarthquakeRestClient;
import io.swagger.annotations.ApiModelProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class EarthquakeController.
 */
@RestController
public class EarthquakeController {
	
	/** The rest client. */
	@Autowired
	EarthquakeRestClient restClient;
	
	
	/**
	 * Retrieve earthquakes by magnitude.
	 *
	 * @param minMagnitude the min magnitude
	 * @param maxMagnitude the max magnitude
	 * @return the mapping jackson value
	 */
	@GetMapping("/earthquakes")
	public MappingJacksonValue retrieveEarthquakesByMagnitude(
			@RequestParam 
			@Valid  
			@Min(value=1, message="The field minMagnitude can't be Null")
			double minMagnitude, 
			@NotNull(message="The field maxMagnitude can't be Null")
			@RequestParam double maxMagnitude) {
		
		Response response = restClient.getEarthQuakesByMagnitude(minMagnitude, maxMagnitude);
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("metadata","features","bbox","type");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		mapping.setFilters(filters);

		return mapping;
	}
	
	/**
	 * Retrieve earthquakes by date.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the mapping jackson value
	 */
	@GetMapping("/earthquakes/date")
	public MappingJacksonValue retrieveEarthquakesByDate(
			@Valid
			@RequestParam("startTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			@Pattern(regexp = "/([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))/" , message="The field startTime must be in yyyy-MM-dd format")
			LocalDate startTime,
			@Valid
			@RequestParam("endTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime) {	


		Response response = restClient.getEarthQuakesByDate(startTime,endTime);
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("metadata","features","bbox","type");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		mapping.setFilters(filters);
		
		return mapping;
	}

	
	/**
	 * Retrieve earthquakes by date ranges.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param startTime2 the start time 2
	 * @param endTime2 the end time 2
	 * @return the mapping jackson value
	 */
	@GetMapping("/earthquakes/dates")
	public MappingJacksonValue retrieveEarthquakesByDateRanges(
			@Valid
			@RequestParam("startTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate startTime,
			@Valid
			@RequestParam("endTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime,
			@Valid
			@RequestParam("startTime2") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate startTime2,
			@Valid
			@RequestParam("endTime2") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime2) {	

	
		Response response = restClient.getEarthQuakesByDateRanges(startTime,endTime,startTime2,endTime2);
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("metadata","features");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
	
	/**
	 * Retrieve earthquakes by country.
	 *
	 * @param country the country
	 * @return the mapping jackson value
	 */
	@GetMapping("/earthquakes/countries")
	public MappingJacksonValue retrieveEarthquakesByCountry(
			@Valid
			@RequestParam
			String country
			) {	

	
		Response response = restClient.getEarthquakesByCountry(country);
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("metadata","features");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
	
	
	/**
	 * Retrieve earthquakes by country and date.
	 *
	 * @param country the country
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the mapping jackson value
	 */
	@GetMapping("/earthquakes/countries/dates")
	public MappingJacksonValue retrieveEarthquakesByCountryAndDate(
			@Valid
			@RequestParam
			String country,
			@RequestParam("startTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") 
			LocalDate startTime,
			@Valid
			@RequestParam("endTime") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime
			) {	

	
		Response response = restClient.getEarthquakesByCountryAndDate(country, startTime, endTime);
		
		SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("metadata","features");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(response);
		mapping.setFilters(filters);
		
		
		return mapping;
		
	}
}
