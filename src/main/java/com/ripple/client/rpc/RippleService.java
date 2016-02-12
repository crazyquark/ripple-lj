package com.ripple.client.rpc;

import java.util.LinkedHashMap;

import com.ripple.client.model.AccountInfoRequest;
import com.ripple.client.model.ExtendedAccountInfoRequest;

// XXX: first attempt at fleshing out the Ripple RPC interface
// XXX: Must use objects instead of strings as return types - watch out for errors
// XXX: Handle optional params
public interface RippleService {
	// Ledger
	public String ledger_current();
	
	// Transactions
	public String tx(String transaction, Boolean binary);
	public String sign(Object/*Transaction*/ tx_json, String secret, Boolean offline/*, Boolean build_path, Integer fee_mult_max*/);
	public String submit(String tx_blob, Boolean fail_hard);
	public String submit(Object/*Transaction*/ tx_json, String secret/*, Boolean fail_hard, Boolean offline, Boolean build_path, Integer fee_mult_max*/);
	
	// Account
	// XXX: use proper objects instead of LinkedHashMap
	public LinkedHashMap<String, Object> account_info(AccountInfoRequest params);
	public LinkedHashMap<String, Object>  account_info(ExtendedAccountInfoRequest params);
	public String account_tx(String account/*, Integer ledger_index_min, Integer ledger_index_max*/);
	
	// Server
	public String server_info();
}
