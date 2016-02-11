package com.ripple.client;

import com.ripple.client.rpc.RippleClient;

public class TestRunner {

	public static void main(String[] args) {
		RippleClient client = new RippleClient("localhost", 5105);
		
		System.out.println(client.getRootAccount());
	}

}
