package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_20_SmallestWindowContaining012 {

	//T(C)=O(n)  and S(C)=O(N)
	public static int smallestSubstring(String S) {
		Map<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int f = 0, l = 0;
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
			if (map.size() == 3) {
				f = Math.min(map.get('0'), Math.min(map.get('1'), map.get('2')));
				l = Math.max(map.get('0'), Math.max(map.get('1'), map.get('2')));
				min = Math.min(min, l - f + 1);
			}
		}
		if (map.size() < 3)
			return -1;
		return min;
	}

	public static void main(String[] args) {
		String S = "12201";
		int response = smallestSubstring(S);
		System.out.println("The smallest Substring is " + response);
	}

}
