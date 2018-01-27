package com.waterloo.oec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * Created by Jeff Niu
 */
public class Util {

	public static void println(Object o) {
		System.out.println(o);
	}

	public static String[] jsonArraytoStrArray(JsonArray jarr) {
		String[] strings = new String[jarr.size()];
		for (int i = 0; i < jarr.size(); i++) {
			strings[i] = jarr.get(i).getAsString();
		}
		return strings;
	}

}
