package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CurrentLedgerInfo {
	@JsonProperty("ledger_current_index")
	private Integer ledgerIndex;
	
	private String status;
}
