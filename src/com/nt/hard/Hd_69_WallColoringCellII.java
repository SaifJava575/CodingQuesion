package com.nt.hard;

public class Hd_69_WallColoringCellII {

	// T(C)=O(N*K) and S(C)=O(N*K)
	static int minCost(int[][] costs) {
		int N = costs.length;
		int K = costs[0].length;
		if (K == 1 && N > 1)
			return -1;

		if (K == 1 && N == 1)
			return costs[0][0];

		int[][] dp = new int[N][K];

		for (int i = 0; i < K; i++)
			dp[0][i] = costs[0][i];
		for (int i = 1; i < N; i++) {
			int least = Integer.MAX_VALUE;
			int sleast = Integer.MAX_VALUE;
			for (int j = 0; j < K; j++) {
				if (dp[i - 1][j] <= least) {
					sleast = least;
					least = dp[i - 1][j];
				}

				else if (dp[i - 1][j] <= sleast)
					sleast = dp[i - 1][j];

			}

			for (int j = 0; j < K; j++) {
				if (dp[i - 1][j] == least)
					dp[i][j] = costs[i][j] + sleast;
				else
					dp[i][j] = costs[i][j] + least;

			}
		}
		int ans = dp[N - 1][0];
		for (int i = 0; i < K; i++)
			ans = Math.min(ans, dp[N - 1][i]);
		return ans;
	}

	public static void main(String[] args) {
		int costs[][] = { { 1, 5, 7 }, { 5, 8, 4 }, { 3, 2, 9 }, { 1, 2, 4 } };
		int response = minCost(costs);
		System.out.println("The min painting cost for each Wall ::" + response);

	}

}
