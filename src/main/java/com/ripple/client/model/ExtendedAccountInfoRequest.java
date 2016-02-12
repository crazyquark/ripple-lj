package com.ripple.client.model;

public class ExtendedAccountInfoRequest extends AccountInfoRequest {
	private Boolean strict;
	private String ledger_hash;
	
	public ExtendedAccountInfoRequest(String account, Boolean strict, String ledger_hash) {
		super(account);
		
		this.strict = strict;
		this.ledger_hash = ledger_hash;
	}
	
	public Boolean getStrict() {
		return strict;
	}
	public String getLedger_hash() {
		return ledger_hash;
	}
}
