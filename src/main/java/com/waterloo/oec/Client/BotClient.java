package com.waterloo.oec.Client;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.waterloo.oec.Const;
import com.waterloo.oec.Data.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.Nullable;

import static com.waterloo.oec.Const.*;
import static com.waterloo.oec.Util.errln;
import static com.waterloo.oec.Util.println;

/**
 * Created by Jeff Niu
 */
public class BotClient {

	public static String join(String base, String endpoint) {
		return base + endpoint;
	}

	public final String key;
	public HttpClient client;

	public BotClient() {
		this(Const.KEY);
	}

	public BotClient(String key) {
		this.key = key;
		this.client = HttpClientBuilder.create().build();
	}

	private void addKey(URIBuilder b) {
		b.addParameter("key", key);
	}

	@Nullable
	public AccountResp account() {
		try {
			URIBuilder b = new URIBuilder(BASE + ACCOUNT);
			addKey(b);
			println(b);
			HttpGet get = new HttpGet(b.build());
			HttpResponse resp = client.execute(get);
			String json = EntityUtils.toString(resp.getEntity(), "UTF-8");
			return new AccountResp(new JsonParser().parse(json));
		} catch (Exception e) {
			errln("AccountResp Exception: " + e.toString());
			return null;
		}
	}

	@Nullable
	public ListResp list() {
		try {
			URIBuilder b = new URIBuilder(BASE + LIST);
			addKey(b);
			println(b);
			HttpGet get = new HttpGet(b.build());
			HttpResponse resp = client.execute(get);
			String json = EntityUtils.toString(resp.getEntity(), "UTF-8");
			return new ListResp(new JsonParser().parse(json));
		} catch (Exception e) {
			errln("ListResp Exception: " + e.toString());
			return null;
		}
	}

	@Nullable
	public PriceResp price(String name) {
		try {
			URIBuilder b = new URIBuilder(BASE + STOCK);
			b.addParameter("ticker", name);
			addKey(b);
			println(b);
			HttpGet get = new HttpGet(b.build());
			HttpResponse resp = client.execute(get);
			String json = EntityUtils.toString(resp.getEntity(), "UTF-8");
			return new PriceResp(new JsonParser().parse(json));
		} catch (Exception e) {
			errln("AccountResp Exception: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}

	@Nullable
	public BuyResp buy(String name, int num) {
		try {
			URIBuilder b = new URIBuilder(BASE + BUY);
			b.addParameter("ticker", name);
			b.addParameter("shares", Integer.toString(num));
			addKey(b);
			println(b);
			HttpGet get = new HttpGet(b.build());
			HttpResponse resp = client.execute(get);
			String json = EntityUtils.toString(resp.getEntity(), "UTF-8");
			return new BuyResp(new JsonParser().parse(json));
		} catch (Exception e) {
			errln("AccountResp Exception: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}

	@Nullable
	public SellResp sell(String name, int num) {
		try {
			URIBuilder b = new URIBuilder(BASE + SELL);
			b.addParameter("ticker", name);
			b.addParameter("shares", Integer.toString(num));
			addKey(b);
			println(b);
			HttpGet get = new HttpGet(b.build());
			HttpResponse resp = client.execute(get);
			String json = EntityUtils.toString(resp.getEntity(), "UTF-8");
			return new SellResp(new JsonParser().parse(json));
		} catch (Exception e) {
			errln("AccountResp Exception: " + e.toString());
			e.printStackTrace();
			return null;
		}
	}

}
