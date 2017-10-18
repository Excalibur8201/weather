package com.cgg.weather;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather-service")
public class WeatherController {

	@RequestMapping(value = "/climate-service", method = RequestMethod.GET)
	public ResponseEntity<?> climateService() {

		return new ResponseEntity<>("Respuesta", HttpStatus.OK);
	}
}
