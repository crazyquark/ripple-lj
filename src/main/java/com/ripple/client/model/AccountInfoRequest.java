package com.ripple.client.model;

import com.ripple.client.rpc.RippleClient;

public class AccountInfoRequest {
	private String account;
	
	public AccountInfoRequest() {
		this.account = RippleClient.rootAccount;
	}

	public AccountInfoRequest(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}
}
