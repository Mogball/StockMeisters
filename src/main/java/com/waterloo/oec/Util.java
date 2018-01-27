package com.waterloo.oec;

import com.google.gson.JsonArray;

/**
 * Created by Jeff Niu
 */
public class Util {

	public static void println(Object o) {
		System.out.println(o);
	}

	public static void errln(String err) {
		System.err.println(err);
	}

	public static String[] jarrToStrArr(JsonArray jarr) {
		String[] strings = new String[jarr.size()];
		for (int i = 0; i < jarr.size(); i++) {
			strings[i] = jarr.get(i).getAsString();
		}
		return strings;
	}

	public static int[] jarrToIntArr(JsonArray jarr) {
		int[] ints = new int[jarr.size()];
		for (int i = 0; i < jarr.size(); i++) {
			ints[i] = jarr.get(i).getAsInt();
		}
		return ints;
	}

}
