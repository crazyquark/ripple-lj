package com.ripple.client.rpc;

// XXX: first attempt at fleshing ut the Ripple RPC interface
// XXX: Must use objects instead of strings as return types
// XXX: Handle optional params
public interface RippleRpcInterface {
	// Ledger
	public String ledger_current();
	
	// Transactions
	public String tx(String transaction, Boolean binary);
	public String sign(Object/*Transaction*/ tx_json, String secret, Boolean offline/*, Boolean build_path, Integer fee_mult_max*/);
	public String submit(String tx_blob, Boolean fail_hard);
	public String submit(Object/*Transaction*/ tx_json, String secret/*, Boolean fail_hard, Boolean offline, Boolean build_path, Integer fee_mult_max*/);
	
	// Account
	public String account_info(String account/*, Boolean strict, String ledger_hash, String ledger_index*/);
	public String account_tx(String account/*, Integer ledger_index_min, Integer ledger_index_max*/);
	
	// Server
	public String server_info();
}
