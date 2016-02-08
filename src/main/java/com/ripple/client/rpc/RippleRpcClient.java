package com.ripple.client.rpc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

public class RippleRpcClient {
	protected class RippleAccountInfoReq {
		private String account;

		public RippleAccountInfoReq() {
			this.account = "rHb9CJAWyB4rj91VRWn96DkukG4bwdtyTh";
		}

		public RippleAccountInfoReq(String account) {
			this.account = account;
		}

		public String getAccount() {
			return account;
		}
	}

	private JsonRpcHttpClient jsonRpcClient;

	public RippleRpcClient(String host, int port) {
		URL rippledRpcHost = null;
		try {
			rippledRpcHost = new URL("http://" + host + ":" + Integer.toString(port) + "/");

			this.jsonRpcClient = new JsonRpcHttpClient(rippledRpcHost);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RippleRpcClient() {
		this("localhost", 5005);
	}

	public String getRootAccount() {
		if (this.jsonRpcClient != null) {
			try {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String, Object> result = this.jsonRpcClient.invoke("account_info",
						new Object[] { new RippleAccountInfoReq() }, LinkedHashMap.class);

				return result.toString();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
}
