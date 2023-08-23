package com.nt.string;

public class St_26_FormPalindromeRequired {

	// Dynamic Programming T(C)=O(N^2), N = |str| and S(c)=O(N^2)
	public static int countMin(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String str = "abcd";
		int res = countMin(str);
		System.out.println("Mim number of required character is::" + res);
	}

}
