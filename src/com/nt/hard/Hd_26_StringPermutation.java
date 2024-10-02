package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;

public class Hd_26_StringPermutation {

	static ArrayList<String> list = new ArrayList<>();
	public static ArrayList<String> permutation(String S) {
		helper("", S);
		Collections.sort(list);
		return list;
	}

	public static void helper(String p, String up) {
		if (up.isEmpty()) {
			list.add(p);
			return;
		}
		char ch = up.charAt(0);
		for (int i = 0; i < p.length() + 1; i++) {
			String first = p.substring(0, i);
			String sec = p.substring(i, p.length());
			helper(first + ch + sec, up.substring(1));
		}
	}

	public static void main(String[] args) {
		ArrayList<String> ans = permutation("ABC");
		System.out.println(ans);
	}
}
