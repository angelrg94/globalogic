package cl.globallogic.earthquake.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.globallogic.earthquake.model.Response;
import cl.globallogic.earthquake.rest.client.EarthquakeRestClient;

@RestController
public class EarthquakeController {
	
	@Autowired
	EarthquakeRestClient restClient;
	
	
	@GetMapping("/earthquakes")
	public ResponseEntity retrieveEarthquakesByMagnitude(@RequestParam double minMagnitude, @RequestParam double maxMagnitude) {
		
		System.out.println("Aqui");
		System.out.println("Params: " + minMagnitude + "-" + maxMagnitude);
		
		Response response = restClient.getEarthQuakesByMagnitude(6.0, 7.5);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/earthquakes/date")
	public ResponseEntity retrieveEarthquakesByDate(@RequestParam String startTime, @RequestParam String endTime) {
		
		System.out.println("Aqui");
		System.out.println("Params: " + startTime + "-" + endTime);
		Response response = restClient.getEarthQuakesByDate(startTime,endTime);
		
		return ResponseEntity.ok(response);
	}

}
