package com.nt.string;

import java.util.HashMap;
import java.util.Map;

public class St_18_IsomorphicString {

	//T(c)=O(|str1|+|str2|)  and S(c)= O(Number of different characters).
	public static boolean areIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();

		for (Integer i = 0; i < str1.length(); i++) {

			if (m1.put(str1.charAt(i), i) != m2.put(str2.charAt(i), i)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		String str1 = "aab", str2 = "xyy";
		if (areIsomorphic(str1, str2))
			System.out.println("Two String are isomorphic..........");
		else
			System.out.println("Two String are not isomorphic.............");
	}

}
