package com.nt.dp;

public class Dp_09_PartitionEqualSubSetSum {
	
	public static int equalPartition(int N, int arr[]) {
		int totalSum = 0;
		for (int i = 0; i < N; i++)
			totalSum += arr[i];
		if (totalSum % 2 == 1)
			return 0;
		int target = totalSum / 2;
		boolean dp[][] = new boolean[N + 1][target + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = true;
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 1; j <= target; j++) {
				boolean include = false;
				if (j - arr[i] >= 0)
					include = dp[i + 1][j - arr[i]];
				dp[i][j] = dp[i + 1][j] || include;
			}
		}
		return dp[0][target] == true ? 1 : 0;
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 11, 5};
		int n =arr.length;
		int response=equalPartition(n, arr);
		System.out.println("The equal partition is ::"+response);

	}
}