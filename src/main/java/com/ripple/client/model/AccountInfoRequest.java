package com.ripple.client.model;

import lombok.Data;

/**
 * A POJO to model an account_info request
 * 
 * @See <a href="https://ripple.com/build/rippled-apis/#account-info">rippled docs</a>
 * 
 * @author Cristian Sandu 
 *
 */
@Data
public class AccountInfoRequest {
	private String account;
	private Boolean strict = false;
	private String ledger_index = "validated";
	
	public AccountInfoRequest(String account) {
		this.account = account;
	}
}
