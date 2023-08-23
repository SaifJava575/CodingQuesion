package com.nt.string;

import java.util.HashMap;
import java.util.Map;

public class St_62_CheckFrequencyEqual {

	// T(C)=O(N) and S(C)=o(1)
	public static boolean sameFreq(String s) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
		}
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int val : map1.values()) {
			map2.put(val, map2.getOrDefault(val, 0) + 1);
		}
		if (map2.size() == 1)
			return true;
		if (map2.size() != 2)
			return false;

		int[] freq = new int[2];
		int[] len = new int[2];
		int i = 0;
		for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
			len[i] = e.getKey();
			freq[i] = e.getValue();
			i++;
		}
		if (freq[0] == 1) {
			if (len[0] == 1)
				return true;
			return (len[0] - len[1]) == 1;
		} else if (freq[1] == 1) {
			if (len[1] == 1)
				return true;
			return (len[1] - len[0]) == 1;
		} else
			return false;
	}

	public static void main(String[] args) {
		String str = "xxxxyyzz";
		if (sameFreq(str))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
