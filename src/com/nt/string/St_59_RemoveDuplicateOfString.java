package com.nt.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class St_59_RemoveDuplicateOfString {

	public static String removeDuplicates(String str) {
		String st = "";
		Set<Character> s = new HashSet<>();
		int i = 0;
		while (i < str.length()) {
			if (s.contains(str.charAt(i)))
				i++;
			else {
				s.add(str.charAt(i));
				st += str.charAt(i);
			}
		}
		return st;
	}

	public static String removeDuplicates1(String str) {
		Map<Integer, Character> map = new HashMap<>();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsValue(str.charAt(i))) 
				map.put(i, str.charAt(i));			

		}
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(i)) {
				res += str.charAt(i);
			}
		}

		return res;

	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String res = removeDuplicates1(str);
		System.out.println("Removing the duplicate character the final string is::" + res);
	}

}
