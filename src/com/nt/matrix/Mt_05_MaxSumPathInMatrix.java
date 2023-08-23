package com.nt.matrix;


public class Mt_05_MaxSumPathInMatrix {

	//T(C)= O(N*N)  and S(c)= O(N*N)
	static int maximumPath(int N, int Matrix[][]) {
		int n = N;
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					dp[i][j] = Matrix[i][j];
				} else if (j == 0) {
					dp[i][j] = Matrix[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
				} else if (j == n - 1) {
					dp[i][j] = Matrix[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				} else {
					dp[i][j] = Matrix[i][j] + Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1]));
				}

			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}
		return max;

	}

	public static void main(String[] args) {

		int Matrix[][] = { { 348, 391 }, { 618, 193 } };
		int response=maximumPath(2, Matrix);
		System.out.println("The maxmum path is::"+response);
	}

}
