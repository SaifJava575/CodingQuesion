package com.nt.string;

public class St_51_LongestPalindromeSubsequence {

	//T(C)=O(|S|*|S|).   AND S(C)=O(|S|*|S|).
	public static int longestPalinSubseq(String S) {
		int n = S.length();
		StringBuilder sb = new StringBuilder(S);
		sb = sb.reverse();
		String S1 = sb.toString();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (S.charAt(i - 1) == S1.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][n];
	}

	public static void main(String[] args) {
		String S = "bbabcbcab";
		int res = longestPalinSubseq(S);
		System.out.println("Longest Palindrome subsequence is::" + res);

	}

}
