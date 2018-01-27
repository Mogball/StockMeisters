package com.waterloo.oec;

import com.waterloo.oec.Client.BotClient;
import com.waterloo.oec.Data.AccountResp;
import com.waterloo.oec.Data.BuyResp;
import com.waterloo.oec.Data.ListResp;
import com.waterloo.oec.Data.PriceResp;

import static com.waterloo.oec.Util.println;

public class Main {

	public static void main(String[] args) {
		println("StockMeisters Start");
		BotClient client = new BotClient();
		BuyResp buyr = client.buy("JOE", 1);
		println(buyr);
		AccountResp resp = client.account();
		println(resp);
		ListResp lresp = client.list();
		println(lresp);
		PriceResp presp = client.price("JOE");
		println(presp);


	}
}
