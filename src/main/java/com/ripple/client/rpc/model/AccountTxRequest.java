package com.ripple.client.rpc.model;

import lombok.Data;

/**
 * A POJO to model an account_tx request
 * 
 * @See <a href="https://ripple.com/build/rippled-apis/#account-tx">rippled docs</a>
 * 
 * @author Cristian Sandu 
 *
 */
@Data
public class AccountTxRequest {
	String account;
	Integer ledger_index_min = -1;
	Integer ledger_index_max = -1;
	Boolean binary = false;
	Boolean forward = false;
}
