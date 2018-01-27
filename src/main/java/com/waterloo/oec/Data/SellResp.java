package com.waterloo.oec.Data;

import com.google.gson.JsonElement;

import java.util.Arrays;

/**
 * Created by Jeff Niu
 */
public class SellResp {

	public boolean success;
	public String[] errors;
	public String ticker;

	public SellResp(JsonElement e) {
		BuyResp bp = new BuyResp(e);
		success = bp.success;
		errors = bp.errors;
		ticker = bp.ticker;
	}

	@Override
	public String toString() {
		return "SellResp{" +
				"success=" + success +
				", errors=" + Arrays.toString(errors) +
				", ticker='" + ticker + '\'' +
				'}';
	}
}
