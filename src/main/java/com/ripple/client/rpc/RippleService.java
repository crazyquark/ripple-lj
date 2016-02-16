package com.ripple.client.rpc;

import java.util.LinkedHashMap;

import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.CurrentLedgerInfo;
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
	public CurrentLedgerInfo ledger_current();
	
	// Transactions
	// TODO: add proper response POJOs
	public Transaction tx(TxAddress params);
	public LinkedHashMap<String, Object> sign(AccountTxRequest params);
	public LinkedHashMap<String, Object> submit(SubmitTxRequest params);
	public LinkedHashMap<String, Object> submit(SignTxRequest params);
	
	// Account
	public AccountInfo account_info(AccountInfoRequest params);
	public AccountTxInfo account_tx(AccountTxRequest params);
	
	// Server
	public ServerInfo server_info();
}
