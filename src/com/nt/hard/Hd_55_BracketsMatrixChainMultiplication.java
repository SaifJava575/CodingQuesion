package com.nt.hard;

public class Hd_55_BracketsMatrixChainMultiplication {

	static int dp[][], breakPoint[][];

	public static int mcm(int a[], int i, int j) {
		if (i == j)
			return 0;
		if (dp[i][j] != 0)
			return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		int mini = (int) 1e9;
		for (int k = i; k < j; k++) {
			dp[i][j] = Math.min(dp[i][j], mcm(a, i, k) + mcm(a, k + 1, j) + a[i - 1] * a[k] * a[j]);
			if (dp[i][j] < mini) {
				mini = dp[i][j];
				breakPoint[i][j] = k;
			}
		}
		return dp[i][j];
	}

	static String matrixChainOrder(int p[], int n) {
		dp = new int[n][n];
		breakPoint = new int[n][n];
		mcm(p, 1, n - 1);
		return convertToString(1, n - 1, breakPoint);
	}

	static String convertToString(int i, int j, int[][] store) {
		if (i == j)
			return "" + (char) (i + 64); // 'A'+i-1
		return '(' + convertToString(i, store[i][j], store) + convertToString(store[i][j] + 1, j, store) + ')';
	}

	public static void main(String[] args) {

		int p[] = { 40, 20, 30, 10, 30 };
		int n = p.length;
		String response = matrixChainOrder(p, n);
		System.out.println("The minimum Matrix Chain Multipication is ::" + response);
	}

}
