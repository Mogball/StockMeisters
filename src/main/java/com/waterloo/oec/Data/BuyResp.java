package com.waterloo.oec.Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.waterloo.oec.Util;

import java.util.Arrays;

/**
 * Created by Jeff Niu
 */
public class BuyResp {

	public boolean success;
	public String[] errors;
	public String ticker;

	public BuyResp(JsonElement e) {
		JsonObject o = e.getAsJsonObject();
		success = o.get("success").getAsBoolean();
		JsonArray errArr = o.get("errors").getAsJsonArray();
		errors = Util.jarrToStrArr(errArr);
		ticker = o.get("ticker").getAsString();
	}

	@Override
	public String toString() {
		return "BuyResp{" +
				"success=" + success +
				", errors=" + Arrays.toString(errors) +
				", ticker='" + ticker + '\'' +
				'}';
	}


}
