package com.nt.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class St_20_RemoveDuplicateString {

	// T(C)=O(|s|) and S(C)=O(constant)
	public static String removeDuplicate(String str) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				// map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
				continue;
			} else {
				map.put(str.charAt(i), 1);
				res += str.charAt(i);
			}
		}
		/*
		 * for (Character set : map.keySet()) { res += set; }
		 */
		return res;
	}

	public static void main(String[] args) {
		String str = "saifuddin";
		String res = removeDuplicate(str);
		System.out.println("Remove Duplicate String is::" + res);

	}

}
