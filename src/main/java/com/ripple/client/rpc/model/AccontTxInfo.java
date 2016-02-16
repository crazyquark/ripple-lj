package com.ripple.client.rpc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * A POJO for an account transactions list
 * 
 * @author Cristian Sandu
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccontTxInfo {
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class TxInfo {
		@JsonProperty("ledger_index")
		public Integer ledgerIndex;
		
		// XXX: ignoring meta field for now
		
		public Transaction tx;
		
		public Boolean validated;
	}
	
	private String account;
	
	@JsonProperty("ledger_index_min")
	private Integer minLedgerIndex;
	
	@JsonProperty("ledger_index_max")
	private Integer maxLedgerIndex;
	
	private Boolean validated;
	
	private TxInfo[] transactions;
}
