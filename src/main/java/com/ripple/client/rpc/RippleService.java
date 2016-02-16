package com.ripple.client.rpc;

import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.ServerInfo;
import com.ripple.client.rpc.model.SignTxRequest;
import com.ripple.client.rpc.model.SubmitTxRequest;
import com.ripple.client.rpc.model.Transaction;
import com.ripple.client.rpc.model.TxAddress;

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
	public Transaction tx(TxAddress params);
	public String sign(AccountTxRequest params);
	public String submit(SubmitTxRequest params);
	public String submit(SignTxRequest params);
	
	// Account
	// XXX: use proper objects instead of LinkedHashMap
	public AccountInfo account_info(AccountInfoRequest params);
	public AccountTxInfo account_tx(AccountTxRequest params);
	
	// Server
	public ServerInfo server_info();
}
