package com.nt.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class St_37_FindFirstRepeatedCharacter {

	// T(C)=O(|S|) AND s(c)=O(1)
	public static String findFirstReapeatChar(String s) {
		ArrayList<Character> lst = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (lst.contains(s.charAt(i)))
				return "" + s.charAt(i);
			else
				lst.add(s.charAt(i));
		}
		return "-1";
	}

	static String firstRepChar(String S) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		String response = "";

		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
				if (map.get(S.charAt(i)) > 1) {
					response = response + S.charAt(i);
					return response;
				}
			}

			else {
				map.put(S.charAt(i), 1);
			}
		}

		return "-1";
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String res = firstRepChar(str);
		System.out.println("First Repeated Character position is::" + res);

	}

}
