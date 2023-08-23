package com.nt.string;

import java.util.HashMap;

public class St_56_TwoStringKAnagramCheck {

	public static boolean areKAnagrams(String s1, String s2, int k) {
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			mp.put(ch, mp.getOrDefault(ch, 0) + 1);
		}
		int count = 0;
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (mp.containsKey(ch) && mp.get(ch) > 0)
				mp.put(ch, mp.getOrDefault(ch, 0) - 1);
			else
				count++;

			if (count > k)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "fodr", str2="gork";
		if(areKAnagrams(str1, str2, 2))
			System.out.println("Yes These two string are anagram");
		else 
			System.out.println("No These two string are not anagram");
	}

}
