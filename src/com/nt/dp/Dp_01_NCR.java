package com.nt.dp;

import java.util.Arrays;

public class Dp_01_NCR {

	public static int nCr(int n, int r) {
		if (r > n)
			return 0;
		long[][] dp = new long[n + 1][r + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);
		return (int) solve(n, r, dp);
	}

	public static long solve(int n, int r, long[][] dp) {
		if (r == 0 || n == r)
			return dp[n][r] = 1;
		if (dp[n][r] != -1)
			return dp[n][r];
		else
			return dp[n][r] = (solve(n - 1, r - 1, dp) + solve(n - 1, r, dp)) % 1000000007;
	}

	public static void main(String[] args) {
		
     int response=nCr(4, 2);
     System.out.println("The expected output is::"+response);
	}

}
