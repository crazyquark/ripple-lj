package com.ripple.client.json;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.ripple.client.model.AccountInfo;

public class AccountInfoDeserializer extends JsonDeserializer<AccountInfo> {

	@Override
	public AccountInfo deserialize(JsonParser jsonParser,
			DeserializationContext context) {
		AccountInfo accountInfo = new AccountInfo();
		JsonNode node = null;
		try {
			node = jsonParser.getCodec().readTree(jsonParser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JsonNode accountNode = node.get("account_data");
		if (accountNode != null) {
			accountInfo.setAccount(accountNode.get("Account").asText());
			accountInfo.setBalance(new BigInteger(accountNode.get("Balance").asText()));
			
			return accountInfo;
		} else {
			String error = tryToGetError(node);
			accountInfo.setError(error);

			return accountInfo;
		}
	}

	private String tryToGetError(JsonNode jsonNode) {
		String error = jsonNode.get("error").asText();
		return error;
	}

}
