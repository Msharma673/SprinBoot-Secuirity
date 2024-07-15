package com.projectDemo3.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class BaseResponse {

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private boolean status;
	
}