package com.nt.dp;

public class Dp_12_CountWaysToReachNthStair {

	// T(c)= O(n) and S(C)=O(1)
	public static int countWays(int n) {
		if (n == 1 || n == 2)
			return n;
		long prev_prev_step = 1, prev_step = 2;
		long mod = 1000000007;

		for (int i = 3; i <= n; i++) {
			long current_step = (long) (prev_prev_step + prev_step) % mod;

			prev_prev_step = (prev_step % mod);
			prev_step = current_step;
		}
		return (int) prev_step;
	}

	public static int countWays1(int n) {
		int dp[] = new int[n + 1];
		 int N=(int)1e9+7;
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % N;
		}
		return dp[n];
		
	}

	public static void main(String[] args) {
		int n = 5;
		int response = countWays1(n);
		System.out.println("The output is ::" + response);

	}

}
