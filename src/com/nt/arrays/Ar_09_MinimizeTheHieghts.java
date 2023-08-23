package com.nt.arrays;

import java.util.Arrays;

public class Ar_09_MinimizeTheHieghts {

	// Min hieght I Tree
	// T(c)= O(N*logN) and S(c)=O(N)
	public static int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int min = arr[0] + k;
		int max = arr[n - 1] - k;
		int ans = arr[n - 1] - arr[0];
		for (int i = 0; i < n - 1; i++) {
			int m = Math.min(min, arr[i + 1] - k);
			int N = Math.max(max, arr[i] + k);
			ans = Math.min(ans, N - m);

		}
		return ans;
	}

	// Min hieght II Tree
	public static int getMinDiff1(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int min = arr[0] + k;
		int max = arr[n - 1] - k;
		int ans = arr[n - 1] - arr[0];
		for (int i = 0; i < n - 1; i++) {
			int m = Math.min(min, arr[i + 1] - k);
			int N = Math.max(max, arr[i] + k);
			ans = Math.min(ans, N - m);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 9, 12, 16, 20 };
		int k = 3, n = arr.length;
		int res = getMinDiff(arr, n, k);
		System.out.println("Get MinDifference is::" + res);
	}

}
