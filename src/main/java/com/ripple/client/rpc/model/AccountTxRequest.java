package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * A POJO to model an account_tx request
 * 
 * @See <a href="https://ripple.com/build/rippled-apis/#account-tx">rippled docs</a>
 * 
 * @author Cristian Sandu 
 *
 */
@Data
public class AccountTxRequest {
	private String account;
	
	@JsonProperty("ledger_index_min")
	private Integer minLedgerIndex = -1;
	
	@JsonProperty("ledger_index_max")
	private Integer maxLedgerMax = -1;
	
	private Boolean binary = false;
	private Boolean forward = false;
	
	public AccountTxRequest(String account) {
		this.account = account;
	}
}
