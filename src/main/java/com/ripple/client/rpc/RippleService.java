package com.ripple.client.rpc;

import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.ServerInfo;
import com.ripple.client.rpc.model.Transaction;

// XXX: first attempt at fleshing out the Ripple RPC interface
// XXX: Must use objects instead of strings as return types - watch out for errors
// XXX: Handle optional params
/**
 * A RippleD RPC adapter interface to be used via <code>ProxyUtil</code>
 * @see <a href="https://ripple.com/build/rippled-apis/">rippled docs</a>
 * 
 * @author Cristian Sandu
 *
 */
public interface RippleService {
	// Ledger
	public String ledger_current();
	
	// Transactions 
	public Transaction tx(String transaction/*, Boolean binary*/);
	public String sign(Transaction tx_json, String secret, Boolean offline/*, Boolean build_path, Integer fee_mult_max*/);
	public String submit(String tx_blob, Boolean fail_hard);
	public String submit(Transaction tx_json, String secret/*, Boolean fail_hard, Boolean offline, Boolean build_path, Integer fee_mult_max*/);
	
	// Account
	// XXX: use proper objects instead of LinkedHashMap
	public AccountInfo account_info(AccountInfoRequest params);
	public AccountTxInfo account_tx(AccountTxRequest params);
	
	// Server
	public ServerInfo server_info();
}
