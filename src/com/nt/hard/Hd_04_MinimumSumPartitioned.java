package com.nt.hard;

public class Hd_04_MinimumSumPartitioned {
	
	int[][] dp;

	public int minDifference(int arr[], int n) {
		int totsum = 0;
		for (int i : arr)
			totsum += i;
		dp = new int[n + 1][totsum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= totsum; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		return helper(arr, 0, 0, totsum);
	}

	public int helper(int[] arr, int indx, int sum, int totsum) {
		if (indx >= arr.length)
			return Math.abs(sum - totsum);
		if (dp[indx][sum] != Integer.MAX_VALUE)
			return dp[indx][sum];
		int take = helper(arr, indx + 1, sum + arr[indx], totsum - arr[indx]);
		int nottake = helper(arr, indx + 1, sum, totsum);

		return dp[indx][sum] = Math.min(take, nottake);
	}

	public static void main(String[] args) {
		Hd_04_MinimumSumPartitioned root = new Hd_04_MinimumSumPartitioned();
		int arr[] = { 1, 6, 11, 5 };
		int length = arr.length;
		int resposne = root.minDifference(arr, length);
		System.out.println("The minimum Difference is ::" + resposne);
	}

}
