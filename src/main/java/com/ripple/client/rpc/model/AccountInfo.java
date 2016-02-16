package com.ripple.client.rpc.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A POJO to map to an account_info request
 * 
 * <br><br>Example(root account):
 * {account_data={Account=rHb9CJAWyB4rj91VRWn96DkukG4bwdtyTh,
 *  Balance=100000000000000000, Flags=0, LedgerEntryType=AccountRoot, 
 *  OwnerCount=0, PreviousTxnID=0000000000000000000000000000000000000000000000000000000000000000, 
 *  PreviousTxnLgrSeq=0, Sequence=1, index=2B6AC232AA4C4BE41BF49D2459FA4A0347E1B543A4C92FCEE0821C0201E2E9A8},
 *   ledger_hash=54874B828C5BBC5901946920E61E5B1FEF21175EC50BFA3713740A202B5E412A, 
 *   ledger_index=443, status=success, validated=true
 *   
 * @author Cristian Sandu
 *  
 * @see <a href="https://ripple.com/build/rippled-apis/#account-info">rippled docs</a>
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class AccountInfo {
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public final class AccountData {
		@JsonProperty("Account")
		private String account;
		
		@JsonProperty("Balance")
		private BigInteger balance;
		
		@JsonProperty("Flags")
		public Integer flags;
		
//		// XXX: can this be an enum?
		@JsonProperty("LedgerEntryType")
		private String ledgerEntryType;
		
		@JsonProperty("OwnerCount")
		private Integer ownerCount;
		
		@JsonProperty("PreviousTxnID")
		private String previousTxnID;
		
		@JsonProperty("PreviousTxnLgrSeq")
		private Integer previousTxnLgrSeq;
		
		@JsonProperty("Sequence")
		private Integer sequence;
		
		private String index;
	}
	
	@JsonProperty("account_data")
	private AccountData accountData;
	
	private String ledger_hash;
	private Integer ledger_index;
	private String status;
	private Boolean validated;
}
