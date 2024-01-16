package com.nt.hard;

import java.util.HashMap;

public class Hd_31_WildCardPatternMatching {

	static int wildCard(String pattern, String str) {

		HashMap<String, Boolean> map = new HashMap<>();

		return recursive(pattern, str, 0, 0, map) ? 1 : 0;
	}

	static int wildCard1(String p, String s) {
		int n = s.length();
		int m = p.length();

		int[][] dp = new int[n + 1][m + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= m; i++) {
			dp[0][i] = dp[0][i - 1] * (p.charAt(i - 1) == '*' ? 1 : 0);
		}

		for (int i = 1; i <= n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					int a = dp[i - 1][j];
					int b = dp[i - 1][j - 1];
					int c = dp[i][j - 1];

					dp[i][j] = a | b | c;
				} else {
					dp[i][j] = 0;
				}
			}
		}

		return dp[n][m];
	}

	public static boolean recursive(String p, String s, int i, int j, HashMap<String, Boolean> map) {

		if (i >= p.length() || j >= s.length()) {
			if (i < p.length() && j >= s.length()) {
				for (int k = i; k < p.length(); k++) {
					if (p.charAt(k) != '*')
						return false;
				}
				return true;
			}
			if (i >= p.length() && j >= s.length())
				return true;

			return false;
		}

		String str = "" + i + " " + j;
		if (map.containsKey(str))
			return map.get(str);

		if (s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
			boolean ans = recursive(p, s, i + 1, j + 1, map);
			map.put(str, ans);
			return ans;
		}

		else if (p.charAt(i) == '*') {
			boolean ans = recursive(p, s, i, j + 1, map) || recursive(p, s, i + 1, j, map);
			map.put(str, ans);
			return ans;
		}

		else {
			map.put(str, false);
			return false;
		}

	}

	public static void main(String[] args) {
		String pattern = "ba*a?r";
		String str = "baaababr";
		int response = wildCard1(pattern, str);
		System.out.println("The wildcard pattern matching output is ::" + response);

	}

}
