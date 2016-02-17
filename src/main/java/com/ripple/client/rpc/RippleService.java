package com.ripple.client.rpc;

import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.CurrentLedgerInfo;
import com.ripple.client.rpc.model.ServerInfo;
import com.ripple.client.rpc.model.SignTxRequest;
import com.ripple.client.rpc.model.SignTxResponse;
import com.ripple.client.rpc.model.SubmitTxRequest;
import com.ripple.client.rpc.model.SubmitTxResponse;
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
	public Transaction tx(TxAddress txAddress);
	public SignTxResponse sign(AccountTxRequest tx);
	public SubmitTxResponse submit(SubmitTxRequest tx);
	public SubmitTxResponse submit(SignTxRequest tx);
	
	// Account
	public AccountInfo account_info(AccountInfoRequest account);
	public AccountTxInfo account_tx(AccountTxRequest account);
	
	// Server
	public ServerInfo server_info();
	// public PeersInfo peers();
	// public ConsensusInfo consensus_info();
}
