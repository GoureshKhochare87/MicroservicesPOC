package com.neosoft.microservices.temperatureconversionservice;

import java.math.BigDecimal;

public class TemperatureConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal value;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedValue;
	private String environment;
	
	public TemperatureConversion() { }

	public TemperatureConversion(Long id, String from, String to, BigDecimal value, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedValue, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.value = value;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedValue = totalCalculatedValue;
		this.environment = environment;
	}
	//setters getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getTotalCalculatedValue() {
		return totalCalculatedValue;
	}

	public void setTotalCalculatedValue(BigDecimal totalCalculatedValue) {
		this.totalCalculatedValue = totalCalculatedValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
