package com.nt.sdesheet;

public class SD_10_KadnanAlgorithm {

	// T(c)=O(n) and S(c)=O(1)
	static long maxSubarraySum(int arr[], int n) {
		long sum = 0;
		long maxi = arr[0];
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			maxi = Math.max(maxi, sum);
			if (sum < 0)
				sum = 0;
		}
		return maxi;
	}

	public static void main(String[] args) {

		int Arr[] = { 1, 2, 3, -2, 5 };
		long res = maxSubarraySum(Arr, Arr.length);
		System.out.println("the maximum subarray sum is ::" + res);

	}

}
