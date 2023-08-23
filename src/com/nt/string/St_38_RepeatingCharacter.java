package com.nt.string;

import java.util.Map;
import java.util.TreeMap;

public class St_38_RepeatingCharacter {

	public static void repeatingChar(String str) {
		Map<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			else
				map.put(str.charAt(i), 1);
		}

		for (Map.Entry<Character, Integer> key : map.entrySet()) {
			if (key.getValue() > 1) {
				 System.out.println("Character "+key.getKey()+" Value "+key.getValue());
				// return key.getKey();
			}
		}
		//return '#';

	}

	public static void main(String[] args) {
		repeatingChar("geeksforgeeks");
		// System.out.println("Reating Character is::" + ch);
	}

}
