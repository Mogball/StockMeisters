package com.waterloo.oec.Data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by Jeff Niu
 */
public class Holding {

	public String ticker;
	public int shares;
	public int bookCost;
	public int marketValue;

	public Holding(JsonElement e) {
		JsonObject o = e.getAsJsonObject();
		ticker = o.get("ticker").getAsString();
		shares = o.get("shares").getAsInt();
		bookCost = o.get("book_cost").getAsInt();
		marketValue = o.get("market_value").getAsInt();
	}

	@Override
	public String toString() {
		return "Holding{" +
				"ticker='" + ticker + '\'' +
				", shares=" + shares +
				", bookCost=" + bookCost +
				", marketValue=" + marketValue +
				'}';
	}
}
