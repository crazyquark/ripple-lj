package com.ripple.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.ripple.client.rpc.RippleService;
import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.CurrentLedgerInfo;
import com.ripple.client.rpc.model.ServerInfo;
import com.ripple.client.rpc.model.Transaction;
import com.ripple.client.rpc.model.TxAddress;

/**
 * A base for Ripple clients that wraps a RPC client
 * 
 * @author Cristian Sandu
 *
 */
public class BaseRippleClient {
	public static final String rootAccount = "rHb9CJAWyB4rj91VRWn96DkukG4bwdtyTh";
	
	/**
	 * A Ripple RPC proxy build via jsonrpc4j
	 */
	protected RippleService rippleServiceProxy;
	
	public BaseRippleClient(String host, int port) {
		URL rippledRpcHost = null;
		JsonRpcHttpClient jsonRpcClient = null;
		try {
			rippledRpcHost = new URL("http://" + host + ":" + Integer.toString(port) + "/");

			jsonRpcClient = new JsonRpcHttpClient(rippledRpcHost);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.rippleServiceProxy = ProxyUtil.createClientProxy(getClass().getClassLoader(), RippleService.class, jsonRpcClient);
	}

	public BaseRippleClient() {
		this("localhost", 5005);
	}
	
	public RippleService getRippleServiceProxy() {
		return this.rippleServiceProxy;
	}
	
	public CurrentLedgerInfo getCurrentLedger() {
		return this.rippleServiceProxy.ledger_current();
	}
	
	public AccountInfo getAccountInfo(String account) {
		return this.rippleServiceProxy.account_info(new AccountInfoRequest(account));
	}
	
	public AccountInfo getRootAccountInfo() {
		return this.getAccountInfo(rootAccount);
	}
	
	public ServerInfo getServerInfo() {
		return this.rippleServiceProxy.server_info();
	}

	public AccountTxInfo getRootAccountTxs() {
		return this.getAccountTxs(rootAccount);
	}
	
	public AccountTxInfo getAccountTxs(String account) {
		return this.rippleServiceProxy.account_tx(new AccountTxRequest(account));
	}
	
	public Transaction getTransactionInfo(TxAddress transaction) {
		return this.rippleServiceProxy.tx(transaction);
	}
}
