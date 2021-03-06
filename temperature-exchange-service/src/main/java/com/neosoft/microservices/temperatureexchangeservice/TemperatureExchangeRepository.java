package com.neosoft.microservices.temperatureexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureExchangeRepository extends JpaRepository<TemperatureExchange, Long>{
	TemperatureExchange findByFromAndTo(String from,String to);

}
