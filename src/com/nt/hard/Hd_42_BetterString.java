package com.nt.hard;

import java.util.HashMap;

public class Hd_42_BetterString {

	// T(C)=O(N) and S(C)=O(n)
	public static String betterString(String str1, String str2) {
		
		int n1 = getUniqueSubsequence(str1);
		int n2 = getUniqueSubsequence(str2);

		return n1 >= n2 ? str1 : str2;
	}

	public static int getUniqueSubsequence(String s) {
		HashMap<Character, Integer> hm = new HashMap<>();
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {

			int x = hm.getOrDefault(s.charAt(i - 1), -1);

			dp[i] = (2 * dp[i - 1]) - (x > 0 ? dp[x - 1] : 0);

			hm.put(s.charAt(i - 1), i);

		}

		return dp[s.length()];

	}

	public static void main(String[] args) {
		String str1 = "gfg", str2 = "ggg";
		String response = betterString(str1, str2);
		System.out.println("The better String is ::" + response);
	}

}
