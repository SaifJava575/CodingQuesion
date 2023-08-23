package com.nt.matrix;

public class Mt_06_MatrixChainMultiplication {

	static int matrixMultiplication(int N, int arr[]) {
		int dp[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) 
					dp[i][j] = 0;				
			}
		}

		for (int len = 2; len < N; len++) {
			for (int i = 1; i <= N - len; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int cost1 = dp[i][k];
					int cost2 = dp[k + 1][j];
					int cost3 = arr[i - 1] * arr[k] * arr[j];
					dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
				}
			}
		}

		return dp[1][N - 1];
	}

	public static void main(String[] args) {
    int arr[] = {40, 20, 30, 10, 30};
    int n=arr.length;
    int response=matrixMultiplication(n, arr);
    System.out.println("The chainMatrix output is::"+response);
	}

}
