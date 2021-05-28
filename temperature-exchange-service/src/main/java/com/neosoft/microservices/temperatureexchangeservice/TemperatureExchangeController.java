package com.neosoft.microservices.temperatureexchangeservice;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureExchangeController {
	
	@Autowired
	private TemperatureExchangeRepository repository; 
	
	@Autowired
	private Environment environment; 
	
	@GetMapping("/temperature-exchange/from/{from}/to/{to}")
	public TemperatureExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		TemperatureExchange currencyExchange= repository.findByFromAndTo(from, to);
		if (currencyExchange==null) {
			throw new RuntimeException("Unable to find data for "+from +" to " +to);
		}
		String port=environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
