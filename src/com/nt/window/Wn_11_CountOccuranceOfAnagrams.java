package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_11_CountOccuranceOfAnagrams {

	//T(c)=O(n)  and S(C)= O(26) or O(256)
	public static int search(String pat, String txt) {
		int m = pat.length(), n = txt.length();
		Map<Character, Integer> map = new HashMap<>();
		for (Character ch : pat.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		int i = 0, j = 0;
		int uniqueCharcter = 0, res = 0;
		while (j < n) {
			char ch = txt.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					uniqueCharcter++;
			}
			if (j - i + 1 == m) {
				if (map.size() == uniqueCharcter)
					res++;
				char left = txt.charAt(i);
				if (map.containsKey(left)) {
					map.put(left, map.get(left) + 1);
					if (map.get(left) == 1)
						uniqueCharcter--;
				}
				i++;
			}
			j++;
		}
		return res;
	}

	public static void main(String[] args) {
		String txt = "aabaabaa";
		String pat = "aaba";

		int response = search(pat, txt);
		System.out.println("Count Occurance of Anagrams :" + response);
	}

}
