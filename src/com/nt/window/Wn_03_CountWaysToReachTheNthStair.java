package com.nt.window;

public class Wn_03_CountWaysToReachTheNthStair {

	// T(C)=O(n) and S(C)=O(1)
	public static int countWays(int n) {
		if (n <= 2)
			return n;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		int mod = (int) 1e9 + 7;
		for (int i = 3; i <= n; i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 5;
		int response = countWays(n);
		System.out.println("The number of ways to reach the top of the stair :" + response);
	}

}
