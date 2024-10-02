package com.nt.hard;

public class Hd_54_MaximumProfit {

	// T(C)=O(N*K) and S(C)=O(N*K)
	static int maxProfit(int K, int N, int price[]) {

		int dp[][] = new int[N + 1][2 * K + 1];

		for (int i = N - 1; i >= 0; i--) {
			for (int k = 0; k < 2 * K; k++) {

				if (k % 2 == 0) {
					dp[i][k] = Math.max(-price[i] + dp[i + 1][k + 1], dp[i + 1][k]);
				} else {
					dp[i][k] = Math.max(price[i] + dp[i + 1][k + 1], dp[i + 1][k]);
				}
			}
		}
		return dp[0][0];

	}

	public static void main(String[] args) {
		int A[] = { 10, 22, 5, 75, 65, 80 };
		int N = A.length;
		int k = 2;
		int response = maxProfit(k, N, A);
		System.out.println("The maximum Profit is ::" + response);

	}

}
