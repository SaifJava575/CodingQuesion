package com.nt.hard;

import java.util.Arrays;

public class Hd_27_WildCardStringMatching {

	// T(C),S(C)=O(length of wild string * length of pattern string)
	static boolean match(String wild, String pattern) {
		int n = wild.length(), m = pattern.length();

		int[][] dp = new int[n][m];
		for (int[] dr : dp)
			Arrays.fill(dr, -1);

		return solve(n - 1, m - 1, wild, pattern, dp) == 1 ? true : false;
	}

	static boolean match1(String wild, String pattern) {
		int wildIndex = 0;
		int patternIndex = 0;
		int wildStar = -1;
		int patternStar = -1;

		while (patternIndex < pattern.length()) {
			if (wildIndex < wild.length()
					&& (wild.charAt(wildIndex) == pattern.charAt(patternIndex) || wild.charAt(wildIndex) == '?')) {
				wildIndex++;
				patternIndex++;
			} else if (wildIndex < wild.length() && wild.charAt(wildIndex) == '*') {
				wildStar = wildIndex;
				patternStar = patternIndex;
				wildIndex++;
			} else if (wildStar != -1) {
				wildIndex = wildStar + 1;
				patternIndex = patternStar + 1;
				patternStar++;
			} else {
				return false;
			}
		}

		while (wildIndex < wild.length() && wild.charAt(wildIndex) == '*') {
			wildIndex++;
		}

		return wildIndex == wild.length();
	}

	static int solve(int i, int j, String wild, String pattern, int[][] dp) {
		if (i < 0 && j < 0)
			return 1;
		if (i < 0 && j >= 0)
			return 0;
		if (i >= 0 && j < 0) {
			while (i >= 0) {
				if (wild.charAt(i) != '*')
					return 0;
				i--;
			}
			return 1;
		}

		if (dp[i][j] != -1)
			return dp[i][j];
		if (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?')
			return dp[i][j] = solve(i - 1, j - 1, wild, pattern, dp);

		if (wild.charAt(i) == '*') {
			return dp[i][j] = solve(i - 1, j, wild, pattern, dp) | solve(i, j - 1, wild, pattern, dp);
		}

		return dp[i][j] = 0;
	}

	public static void main(String[] args) {
		String wild = "ge?ks*";
		String pattern = "geeksfor";
		if (match1(wild, pattern))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
