package com.waterloo.oec;

import com.waterloo.oec.Client.BotClient;
import com.waterloo.oec.Data.AccountResp;
import com.waterloo.oec.Data.ListResp;

import static com.waterloo.oec.Util.println;

public class Main {

	public static void main(String[] args) {
		println("StockMeisters Start");
		BotClient client = new BotClient();
		AccountResp resp = client.account();
		println(resp);
		ListResp lresp = client.list();
		println(lresp);
	}
}
