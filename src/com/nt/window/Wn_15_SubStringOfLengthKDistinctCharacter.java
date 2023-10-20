package com.nt.window;

import java.util.HashMap;
import java.util.Map;

public class Wn_15_SubStringOfLengthKDistinctCharacter {

	//T(c)= O(|S|)  and S(C)= O(|S|)
	static int countOfSubstrings(String S, int K) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < K; i++) {
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
		}
		if (map.size() == K - 1) {
			count++;
		}
		for (int i = K; i < S.length(); i++) {
			if (map.get(S.charAt(i - K)) == 1) {
				map.remove(S.charAt(i - K));
			} else {
				map.put(S.charAt(i - K), map.get(S.charAt(i - K)) - 1);
			}
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
			if (map.size() == K - 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String S = "aabab";
		int k = 3;
		int response = countOfSubstrings(S, k);
		System.out.println("Distinct Character of all substring " + response);
	}

}
