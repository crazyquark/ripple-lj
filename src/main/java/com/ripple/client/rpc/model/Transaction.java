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
	
	@JsonProperty("Destination")
	private String destinationAccount;
	
	@JsonProperty("Flags")
	private Integer flags;
	
	// TODO: this is tricky since it can be both a number and an object(for non-XRP)
	/**
	 * Amount object or integer?
	 * @see <a href="https://ripple.com/build/rippled-apis/#specifying-currency-amounts">ripple amount objects</a>
	 */
	@JsonProperty("Amount")
	private String amount;
	
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
