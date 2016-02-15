package com.ripple.client.rpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.ripple.client.model.AccountInfo;
import com.ripple.client.rpc.model.AccountInfoRequest;

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
	
	public AccountInfo getRootAccount() {
		return this.rippleService.account_info(new AccountInfoRequest(rootAccount));
	}
	
	public LinkedHashMap<String, Object> getServerInfo() {
		return this.rippleService.server_info();
	}
	
//	public String getRootAccount() {
//		if (this.jsonRpcClient != null) {
//			try {
//				@SuppressWarnings("unchecked")
//				LinkedHashMap<String, Object> result = this.jsonRpcClient.invoke("account_info",
//						new Object[] { new RippleAccountInfoReq() }, LinkedHashMap.class);
//
//				return result.toString();
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return null;
//	}
}
