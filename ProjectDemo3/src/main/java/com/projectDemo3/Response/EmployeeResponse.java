package com.projectDemo3.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeResponse {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("dept")
	private String dept;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("position")
	private String position;
	
	@JsonProperty("age")
	private String age;


}
