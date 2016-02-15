package com.ripple.client.model;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ripple.client.json.AccountInfoDeserializer;

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
@JsonDeserialize(using = AccountInfoDeserializer.class)
public class AccountInfo extends AbstractInfo {
//	@ToString
//	public final class AccountData {
//		public String Account;
//		public String Balance;
//		public Integer Flags;
//		// XXX: can this be an enum?
//		public String LedgerEntryType;
//		public Integer OwnerCount;
//		public String PreviousTxnID;
//		public Integer PreviousTxnLgrSeq;
//		public Integer Sequence;
//		public String index;
//	}
	
//	private AccountData account_data;
//	private String ledger_hash;
//	private Integer ledger_index;
//	private String status;
//	private Boolean validated;
	private BigInteger balance;
	private String account;
}
