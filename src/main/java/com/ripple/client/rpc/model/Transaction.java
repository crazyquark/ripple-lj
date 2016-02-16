package com.ripple.client.rpc.model;

import java.math.BigInteger;

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
	
	// XXX: if this is null will it be automatically added by RippleD?
	@JsonProperty("Sequence")
	private Integer sequence;
	
	@JsonProperty("Fee")
	private BigInteger fee;
	
	@JsonProperty("SigningPubKey")
	private String signingPubKey;
	
	@JsonProperty("TxnSignature")
	private String signature;
}
