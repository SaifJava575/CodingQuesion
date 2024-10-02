package com.nt.window;

import java.util.HashMap;

public class Wn_06_LongestSubStringWithoutRepeatingCharcter {

	// T(C)=O(n) and S(C)=O(K)
	public static int longestUniqueSubsttr(String S) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int j = 0, i = 0, max = 0;
		while (j < S.length()) {
			char ch = S.charAt(j);
			if (hm.containsKey(ch)) {
				i = Math.max(hm.get(ch) + 1, i); // Update i to the next index after the repeating character.
			}
			hm.put(ch, j); // Update the index of the character in the HashMap.
			max = Math.max(j - i + 1, max);
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		String input = "geeksforgeeks";
		int response = longestUniqueSubsttr(input);
		System.out.println("Longest Repeating Character length is " + response);
	}

}
