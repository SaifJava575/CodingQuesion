package com.nt.window;

import java.util.HashMap;
import java.util.HashSet;

public class Wn_08_SmallestDistinctWindow {

	// T(C)=O(256.N) and S(C)=O(256)
	public static int findSubString(String str) {
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < str.length(); i++)
			hs.add(str.charAt(i));

		HashMap<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.size() == hs.size() && j < str.length()) {
				char val = str.charAt(j);
				map.put(val, map.get(val) - 1);
				if (map.get(val) <= 0) {
					map.remove(val);
					min = Math.min(min, i - j + 1);
				}
				j++;
			}
		}
		return min;
	}

	public static int findSubString1(String str) {
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			hs.add(str.charAt(i));
		}
		HashMap<Character, Integer> hm = new HashMap<>();
		int ans = Integer.MAX_VALUE;
		for (int i = 0, j = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);
			while (hm.size() == hs.size() && j < str.length()) {
				char c = str.charAt(j);
				hm.put(c, hm.get(c) - 1);
				if (hm.get(c) <= 0) {
					hm.remove(c);
					ans = Math.min(ans, i - j + 1);
				}
				j++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String str = "AABBBCBBAC";
		int response = findSubString(str);
		System.out.println("Smalles Distinct WIndow Size is ::" + response);
	}

}
