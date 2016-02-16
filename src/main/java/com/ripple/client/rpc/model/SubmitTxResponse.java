package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitTxResponse {
	@JsonProperty("engine_result")
	private String engineResult;
	
	@JsonProperty("engine_result_code")
	private Integer engineResultCode;
	
	private String status;
	
	@JsonProperty("tx_blob")
	private String binaryTx;
	
	@JsonProperty("tx_json")
	private Transaction tx;
}
