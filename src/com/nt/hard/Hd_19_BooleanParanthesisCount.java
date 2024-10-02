package com.nt.hard;

import java.util.Arrays;

public class Hd_19_BooleanParanthesisCount {

	static final int mod = 1003;

	// T(C)=O(n^3) and S(C)=O(N^2)
	public static int countWays(int N, String S) {
		long dp[][][] = new long[N][N][2];
		for (long[][] row1 : dp) {
			for (long[] row : row1) {
				Arrays.fill(row, -1);
			}
		}
		return (int) count(0, N - 1, 1, S, dp) % mod;
	}

	static long count(int i, int j, int isTrue, String S, long dp[][][]) {

		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == 1) {
				return S.charAt(i) == 'T' ? 1 : 0;
			} else {
				return S.charAt(i) == 'F' ? 1 : 0;
			}
		}

		if (dp[i][j][isTrue] != -1)
			return dp[i][j][isTrue];

		long ways = 0;

		for (int k = i + 1; k <= j - 1; k += 2) {

			long lT = count(i, k - 1, 1, S, dp);
			long lF = count(i, k - 1, 0, S, dp);
			long rT = count(k + 1, j, 1, S, dp);
			long rF = count(k + 1, j, 0, S, dp);

			if (S.charAt(k) == '&') {
				if (isTrue == 1) {
					ways = (ways + (lT * rT) % mod) % mod;
				} else {
					ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
				}
			} else if (S.charAt(k) == '|') {
				if (isTrue == 1) {
					ways = (ways + (lT * rT) % mod + (lF * rT) % mod + (lT * rF) % mod) % mod;
				} else {
					ways = (ways + (lF * rF) % mod) % mod;
				}
			} else {
				if (isTrue == 1) {
					ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
				} else {
					ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
				}
			}
		}
		return dp[i][j][isTrue] = ways;

	}

	public static void main(String[] args) {

		String S = "T|T&F^T";
		int N = 7;
		int response = countWays(N, S);
		System.out.println("The number of ways to count ::" + response);
	}

}
