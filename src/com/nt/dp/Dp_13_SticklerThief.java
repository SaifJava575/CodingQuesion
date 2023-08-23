package com.nt.dp;

public class Dp_13_SticklerThief {

	//T(C)=O(N).  and S(C)=O(n)
	public static int findMaxSum(int arr[], int n) {
		int[] dp = new int[n];
		if (n == 1)
			return arr[n - 1];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[1], arr[0]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 5, 10, 100, 10, 5 };
		int n = arr.length;
		int response = findMaxSum(arr, n);
		System.out.println("Maximum Amount is::" + response);

	}

}
