package com.nt.dp;

public class Dp_03_01knapSackProblem {

	public static int knapSack(int W, int wt[], int val[], int n) {
		int dp[][] = new int[n + 1][W + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = -1;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (j >= wt[i - 1])
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][W];

	}

	public static void main(String[] args) {

		int N = 3;
		int W = 4;
		int values[] = { 1, 2, 3 };
		int weight[] = { 4, 5, 1 };
		int response=knapSack(W, weight, values, N);
		System.out.println("The max profit is::"+response);
	}

}
