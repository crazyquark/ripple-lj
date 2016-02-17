package com.ripple.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.ripple.client.rpc.RippleService;

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
}
