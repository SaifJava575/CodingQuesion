package com.nt.hard;

public class Hd_36_SplitArraysLargestSum {

	// T(C)=O(N*log(sum(arr))) and S(C)= O(1)
	public static int splitArray(int[] arr, int N, int K) {
		if (K > arr.length)
			return -1;
		int s = 0, max = -1;
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
			max = Math.max(arr[i], max);
		}
		int low = max, high = s;
		while (low <= high) {
			int mid = (low + high) / 2;
			int no_subarrays = fun(arr, mid);
			if (no_subarrays > K)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}

	public static int fun(int[] arr, int k) {
		int c = 1, s = 0;
		for (int i = 0; i < arr.length; i++) {
			if (s + arr[i] <= k)
				s += arr[i];
			else {
				c++;
				s = arr[i];
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int K = 3;
		int arr[] = { 1, 2, 3, 4 };
		int N = arr.length;
		int response = splitArray(arr, N, K);
		System.out.println(response);

	}

}
