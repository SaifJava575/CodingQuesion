package com.nt.hard;

public class Hd_15_PainterPartionedProblem {

	// T(C)=O(n log m) and S(C)=O(1)
	public static long minTime(int[] arr, int n, int k) {
		long low = 0, high = 0;

		for (int i = 0; i < n; i++) {
			low = Math.max(low, arr[i]);
			high += arr[i];
		}
		while (low < high) {
			long mid = low + (high - low) / 2;
			if (isValid(arr, n, k, mid))
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	public static boolean isValid(int[] arr, int n, int k, long time) {
		long currentTime = 0;
		int painters = 1;
		for (int i = 0; i < n; i++) {
			currentTime += arr[i];
			if (currentTime > time) {
				painters++;
				currentTime = arr[i];
			}
		}
		return painters <= k;

	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 30, 20, 15 };
		int n = arr.length;
		int k = 3;
		long response = minTime(arr, n, k);
		System.out.println("The most optimal Solution is:" + response);

	}

}
