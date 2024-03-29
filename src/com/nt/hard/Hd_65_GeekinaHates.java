package com.nt.hard;

import java.util.Arrays;

public class Hd_65_GeekinaHates {

	//T(c)= O(k*log(n) + constant)   and S(C)= O(k*log(n) + constant)
	public static long findNthNumer(int n, int k) {
		long low = 0, high = (long) (1e18);
		dp = new Long[2][65][65];
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long count = find(mid, k);
			if (count >= n)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	private static long find(long n, int k) {
		char s[] = Long.toBinaryString(n).toCharArray();
		reset();
		return dp(s, s.length, 1, k);
	}

	private static long dp(char s[], int n, int tight, int k) {
		if (k < 0)
			return 0;
		if (n == 0) {
			return 1;
		}
		if (dp[tight][k][n] != null)
			return dp[tight][k][n];
		int ub = (tight == 1 ? (int) (s[s.length - n] - '0') : 1);
		long ans = 0;
		for (int dig = 0; dig <= ub; dig++) {
			if (dig == ub)
				ans += dp(s, n - 1, tight, k - dig);
			else
				ans += dp(s, n - 1, 0, k - dig);
		}
		return dp[tight][k][n] = ans;
	}

	private static void reset() {
		for (int i = 0; i < 65; i++) {
			Arrays.fill(dp[0][i], null);
			Arrays.fill(dp[1][i], null);
		}
	}

	private static Long dp[][][];

	public static void main(String[] args) {

		int n = 5;
		int k = 1;

		long response = findNthNumer(n, k);
		System.out.println("Find Nth number is ::" + response);

	}
}
