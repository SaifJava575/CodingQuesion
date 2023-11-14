package com.nt.advanceddsa;

import java.util.Arrays;
import java.util.HashSet;

public class Ad_09_LongestStringArray {

	// T(c)= O(NlogN) and S(C)=O(N)
	public static String longestString(int n, String[] arr) {
		Arrays.sort(arr);
		String longest = "";
		HashSet<String> prefixSet = new HashSet<>();
		for (String s : arr) {
			boolean isValid = true;
			for (int i = 1; i < s.length(); i++) {
				String prefix = s.substring(0, i);
				if (!prefixSet.contains(prefix)) {
					isValid = false;
					break;
				}
			}

			if (isValid) {
				if (s.length() > longest.length())
					longest = s;
			}

			prefixSet.add(s);
		}

		return longest;
	}

	public static void main(String[] args) {
		String arr[] = { "ab", "a", "aa", "abd", " abc", " abda", " abdd", " abde", " abdab" };
		int n = arr.length;
		String response = longestString(n, arr);
		System.out.println(response);
	}

}
