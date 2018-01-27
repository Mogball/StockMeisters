package com.waterloo.oec.Client;

import com.waterloo.oec.Const;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by Jeff Niu
 */
public class BotClient {

	public final String key;
	public HttpClient client;

	public BotClient() {
		this(Const.KEY);
	}

	public BotClient(String key) {
		this.key = key;
		this.client = HttpClientBuilder.create().build();
	}



}
