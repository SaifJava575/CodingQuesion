package com.nt.arrays;

public class Ar_03_KadnansAlgorithm {

	public static long maxSubarraySum(int arr[], int n) {
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (long) arr[i];
			if (sum > max)
				max = sum;

			if (sum < 0)
				sum = 0;
		}
		return max;
	}

	public static void main(String[] args) {
		int Arr[] = { 1, 2, 3, -2, 5 };
		int n = Arr.length;
		long res = maxSubarraySum(Arr, n);
		System.out.println("Maximum SubArray sum is::"+res);
	}

}
