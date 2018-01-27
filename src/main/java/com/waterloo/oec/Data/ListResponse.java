package com.waterloo.oec.Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by Jeff Niu
 */
public class ListResponse {

	public boolean success;
	public String[] errors;
	public String[] stockTickers;

	public ListResponse(JsonElement ele) {
		JsonObject obj = ele.getAsJsonObject();
		success = obj.get("success").getAsBoolean();
		JsonArray errorsArr = obj.get("errors").getAsJsonArray();

	}

}
