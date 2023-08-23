package com.nt.string;

import java.util.HashMap;

public class St_33_ShortestCommonSuperSequence {

	// It is not correct
	public static int scss(String X, String Y, int m, int n) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			if (map.containsKey(X.charAt(i)))
				map.put(X.charAt(i), map.get(X.charAt(i)) + 1);
			else
				map.put(X.charAt(i), 1);
		}

		for (int i = 0; i < n; i++) {
			if (map.containsKey(Y.charAt(i)))
				map.put(Y.charAt(i), map.get(Y.charAt(i)) + 1);
			else
				map.put(Y.charAt(i), 1);
		}
		return map.size();
	}

	// Dp Problem
	public static int shortestCommonSupersequence(String s1, String s2, int x, int y) {
		int[][] dp = new int[x + 1][y + 1];
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return x + y - dp[x][y];
	}

	public static void main(String[] args) {
		String x = "abcd", y = "xycd";
		int res = shortestCommonSupersequence(x, y, 4, 4);
		System.out.println("Shortest Common Super Sequence is::" + res);
	}

}
