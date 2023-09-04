package com.nt.hash;

import java.util.HashMap;
import java.util.Map;

public class Hm_10_NonRepeatingCharacter {

	// T(c)=O(n) and S(C)=O(n)
	public static char nonrepeatingCharacter(String S) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
		}
		for (int i = 0; i < S.length(); i++) {
			if (map.get(S.charAt(i)) == 1)
				return S.charAt(i);
		}
		return '$';
	}

	public static void main(String[] args) {
		String S = "zxvczbtxyzvy";
		char response = nonrepeatingCharacter(S);
		System.out.println("First non Repeating Character is " + response);
	}

}
