package com.waterloo.oec.Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.waterloo.oec.Util;

import java.util.Arrays;

/**
 * Created by Jeff Niu
 */
public class AccountResp {

	public static Holding[] jarrToHoldings(JsonArray jarr) {
		Holding[] holdings = new Holding[jarr.size()];
		for (int i = 0; i < jarr.size(); i++) {
			holdings[i] = new Holding(jarr.get(i));
		}
		return holdings;
	}

	public boolean success;
	public String[] errors;
	public int cash;
	public Holding[] holdings;

	public AccountResp(JsonElement e) {
		JsonObject o = e.getAsJsonObject();
		success = o.get("success").getAsBoolean();
		errors = Util.jarrToStrArr(o.get("errors").getAsJsonArray());
		cash = o.get("cash").getAsInt();
		holdings = jarrToHoldings(o.get("holdings").getAsJsonArray());
	}

	@Override
	public String toString() {
		return "AccountResp{" +
				"success=" + success +
				", errors=" + Arrays.toString(errors) +
				", cash=" + cash +
				", holdings=" + Arrays.toString(holdings) +
				'}';
	}
}
