package com.neosoft.microservices.temperatureconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TemperatureConversionController {
	
	@Autowired
	private TemperatureExchangeProxy proxy;
	
	@GetMapping("/temperature-conversion-feign/from/{from}/to/{to}/value/{value}")
	public TemperatureConversion calculateTemperatureConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal value) {
		
		
		TemperatureConversion temperatureConversion=proxy.retrieveExchangeValue(from, to);
		if(from.equals("C")) {
		BigDecimal b1 = new BigDecimal("1.8");
		BigDecimal b2 = new BigDecimal("32");
		return new TemperatureConversion(temperatureConversion.getId(),
				from,to,value,
				temperatureConversion.getConversionMultiple(),
				value.multiply(b1).add(b2),
				temperatureConversion.getEnvironment()+" "+"feign");
		}
		else {
			BigDecimal b1 = new BigDecimal("0.555555555");
			BigDecimal b2 = new BigDecimal("32");
			
			return new TemperatureConversion(temperatureConversion.getId(),
					from,to,value,
					temperatureConversion.getConversionMultiple(),
					value.subtract(b2).multiply(b1),
					temperatureConversion.getEnvironment()+" "+"feign");	
		}
		
	}
}
