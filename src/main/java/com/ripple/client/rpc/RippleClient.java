package com.ripple.client.rpc;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.ripple.client.rpc.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;
import com.ripple.client.rpc.model.AccountTxInfo;
import com.ripple.client.rpc.model.AccountTxRequest;
import com.ripple.client.rpc.model.ServerInfo;

/**
 * The main entrypoint to use ripple via RPC
 * 
 * @author Cristian Sandu
 *
 */
public class RippleClient {
	public static final String rootAccount = "rHb9CJAWyB4rj91VRWn96DkukG4bwdtyTh";
	
	private RippleService rippleService;
	
	public RippleClient(String host, int port) {
		URL rippledRpcHost = null;
		JsonRpcHttpClient jsonRpcClient = null;
		try {
			rippledRpcHost = new URL("http://" + host + ":" + Integer.toString(port) + "/");

			jsonRpcClient = new JsonRpcHttpClient(rippledRpcHost);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.rippleService = ProxyUtil.createClientProxy(getClass().getClassLoader(), RippleService.class, jsonRpcClient);
	}

	public RippleClient() {
		this("localhost", 5005);
	}
	
	public AccountInfo getAccountInfo(String account) {
		return this.rippleService.account_info(new AccountInfoRequest(account));
	}
	
	public AccountInfo getRootAccountInfo() {
		return this.getAccountInfo(rootAccount);
	}
	
	public ServerInfo getServerInfo() {
		return this.rippleService.server_info();
	}

	public AccountTxInfo getRootAccountTxs() {
		return this.rippleService.account_tx(new AccountTxRequest(rootAccount));
	}
}
