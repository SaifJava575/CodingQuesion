package com.nt.string;

public final class St_23_LongestRepeatingSubString {

	//T(C)=O(n2)  and S(C)=O(n2)
	public static int LongestRepeatingSubsequence(String str) {
		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
		 	dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		String str = "axxxy";
		int res = LongestRepeatingSubsequence(str);
		System.out.println("Longest Repeating SubSequence is::" + res);
	}

}
