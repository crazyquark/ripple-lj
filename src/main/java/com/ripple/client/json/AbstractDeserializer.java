package com.ripple.client.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class AbstractDeserializer<T> extends JsonDeserializer<T>{

	@Override
	public T deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String tryToGetError(JsonNode jsonNode) {
		String error = jsonNode.get("error").asText();
		return error;
	}
}
