package com.ripple.client.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.ripple.client.model.AccountInfo;

public class AccountInfoDeserializer extends JsonDeserializer<AccountInfo>{

	@Override
	public AccountInfo deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
