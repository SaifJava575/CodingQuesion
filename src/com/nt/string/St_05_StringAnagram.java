package com.nt.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class St_05_StringAnagram {

	// T(C)=O(|a|+|b|). and S(C)= O(Number of distinct characters).
	public static boolean checkAnagram(String a, String b) {
		if (a == null || b == null)
			return false;
		else if (a.length() != b.length())
			return false;
		else {
			List<Character> aChar = new ArrayList<>();
			for (int i = 0; i < a.length(); i++)
				aChar.add(a.charAt(i));

			List<Character> bChar = new ArrayList<>();
			for (int j = 0; j < b.length(); j++)
				bChar.add(b.charAt(j));
			if (aChar.size() != bChar.size())
				return false;
			Collections.sort(aChar);
			Collections.sort(bChar);
			for (int i = 0; i < aChar.size(); i++) {
				if (aChar.get(i) != bChar.get(i))
					return false;

			}
		}
		return true;
	}

	public static boolean isAnagramCheck(String s1, String s2) {
		String a = s1.toLowerCase();
		String b = s2.toLowerCase();
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();

		Arrays.sort(aChar);
		Arrays.sort(bChar);
		if (Arrays.equals(aChar, bChar))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String a = "act", b = "tac";
		if (isAnagramCheck(a, b))
			System.out.println("Yes!!! this string is anagram");
		else
			System.out.println("No!!! this string is not anagram");
	}

}
