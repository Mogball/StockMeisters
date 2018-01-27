package com.waterloo.oec.Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.waterloo.oec.Util;

import java.util.Arrays;

/**
 * Created by Jeff Niu
 */
public class PriceResp {

	public boolean success;
	public String[] errors;
	public String ticker;
	public int price;
	public int[] histPrices;

	public PriceResp(JsonElement e) {
		JsonObject o = e.getAsJsonObject();
		success = o.get("success").getAsBoolean();
		JsonArray errArr = o.get("errors").getAsJsonArray();
		errors = Util.jarrToStrArr(errArr);
		ticker = o.get("ticker").getAsString();
		price = o.get("price").getAsInt();
		JsonArray priceArr = o.get("historical_prices").getAsJsonArray();
		histPrices = Util.jarrToIntArr(priceArr);
	}

	@Override
	public String toString() {
		return "PriceResp{" +
				"success=" + success +
				", errors=" + Arrays.toString(errors) +
				", ticker='" + ticker + '\'' +
				", price=" + price +
				", histPrices=" + Arrays.toString(histPrices) +
				'}';
	}
}
