package com.nt.string;

import java.util.HashMap;

public class St_32_LongestKUniqueSubString {

	//T(c)= O(|S|).   and S(C)= O(|S|). 
	public static int longestkSubstr(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int ans = -1;
		while (i < s.length()) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.size() == k) {
				ans = Math.max(ans, (i - j + 1));
			} else {
				while (map.size() > k) {
					char ch = s.charAt(j);
					int count = map.get(ch);
					if (count == 1)
						map.remove(ch);
					else
						map.put(ch, count - 1);
					j++;
				}
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "aabacbebebe";
		int k = 3;
		int result = longestkSubstr(str, k);
		System.out.println("Longest Substring with k unique Character " + result);
	}

}
