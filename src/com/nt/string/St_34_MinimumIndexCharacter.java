package com.nt.string;

import java.util.HashSet;

public class St_34_MinimumIndexCharacter {

	// T(C)=O(N). AND S(C)=O(Number of distinct characters).
	public static int minIndexChar(String str, String patt) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < patt.length(); i++) {
			set.add(patt.charAt(i));
		}
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				return i;
		}
		return -1;
	}

	public static int minIndexChar1(String str, String patt) {
		for (int i = 0; i < str.length(); i++) {
			String s = String.valueOf(str.charAt(i));
			if (patt.contains(s))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "saifuddin", patt = "set";
		int res = minIndexChar1(str, patt);
		System.out.println("Minimum Index Character is::" + res);

	}

}
