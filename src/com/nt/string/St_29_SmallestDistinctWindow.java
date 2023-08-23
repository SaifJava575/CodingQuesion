package com.nt.string;

import java.util.HashMap;
import java.util.HashSet;

public class St_29_SmallestDistinctWindow {

	public static int findSubString(String str) {
		HashSet<Character> set = new HashSet<>();
		HashMap<Character, Integer> map = new HashMap<>();
		int distinct = 0;
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}
		int i = 0, ans = Integer.MAX_VALUE, j = 0;
		while (i < str.length()) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
			if (map.size() == set.size()) {
				while (map.get(str.charAt(j)) > 1) {
					map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) - 1);
					j++;
				}
				ans = Math.min(ans, i - j + 1);
			}
			i++;
		}
		return ans;
	}

	public static int findSubString1(String str) {
		String input = str;
		int distinct = (int) input.chars().distinct().count();
		int min = input.length();
		HashMap<Character, Integer> freq = new HashMap<>();
		int j = 0;

		for (int i = 0; i < input.length(); i++) {
			if (freq.containsKey(input.charAt(i))) {
				freq.put(input.charAt(i), freq.get(input.charAt(i)) + 1);
			} else {
				freq.put(input.charAt(i), 1);
			}
			while (freq.get(input.charAt(j)) > 1) {
				freq.put(input.charAt(j), freq.get(input.charAt(j)) - 1);
				j++;
			}
			if (freq.size() == distinct) {
				min = Math.min(min, i + 1 - j);
			}
		}
		return min;
	}

	public static void main(String[] args) {

		String str = "AABBBCBBAC";
		int res = findSubString1(str);
		System.out.println("Smallest Distinct window is:" + res);

	}

}
