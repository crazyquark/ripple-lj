package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignTxRequest {
	@JsonProperty("tx_json")
	private Transaction tx;
	
	private String secret;
	
	private Boolean offline = false;
}
