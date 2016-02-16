package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignTxResponse {
	private String status;
	
	@JsonProperty("tx_blob")
	private String signedBinaryTx;
	
	@JsonProperty("tx_json")
	private Transaction signedTx;
}
