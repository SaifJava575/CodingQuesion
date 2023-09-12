package com.nt.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hm_13_FirstNonRepeatingCharacterInStream {

	//T(c)=O(n)  and S(C)=O(n)
	public static String FirstNonRepeating(String A) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			char s = '#';
			for (Map.Entry<Character, Integer> val : map.entrySet()) {
				if (val.getValue() == 1) {
					s = val.getKey();
					break;
				}

			}
			result.append(s);
		}
		return result.toString();

	}

	public static void main(String[] args) {
		String input = "aabcd";
		String response = FirstNonRepeating(input);
		System.out.println(response);
	}

}
