package com.waterloo.oec.Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.waterloo.oec.Util;

import java.util.Arrays;

/**
 * Created by Jeff Niu
 */
public class ListResp {

	public boolean success;
	public String[] errors;
	public String[] stockTickers;

	public ListResp(JsonElement ele) {
		JsonObject obj = ele.getAsJsonObject();
		success = obj.get("success").getAsBoolean();
		JsonArray errorsArr = obj.get("errors").getAsJsonArray();
		errors = Util.jarrToStrArr(errorsArr);
		JsonArray stockArr = obj.get("stock_tickers").getAsJsonArray();
		stockTickers = Util.jarrToStrArr(stockArr);
	}

	@Override
	public String toString() {
		return "ListResp{" +
				"success=" + success +
				", errors=" + Arrays.toString(errors) +
				", stockTickers=" + Arrays.toString(stockTickers) +
				'}';
	}

}
