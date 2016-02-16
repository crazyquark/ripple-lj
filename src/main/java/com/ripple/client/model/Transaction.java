package com.ripple.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
	public enum TransactionType {
		Payment, OfferCreate, OfferCancel, TrustSet, AccountSet, SetRegularKey
	}
	
	@JsonProperty("TransactionType")
	private TransactionType transactionType;
	
	@JsonProperty("Account")
	private String senderAccount;
	
	@JsonProperty("Flags")
	private Integer flags;
	
	@JsonProperty("Sequence")
	private Integer sequence;
	
	@JsonProperty("SigningPubKey")
	private String signingPubKey;
	
	@JsonProperty("TxnSignature")
	private String signature;
}
