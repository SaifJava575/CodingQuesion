package com.nt.arrays;

public class Ar_18_PeakElement {

	//T(C)=O(log N) and S(C)=O(1)
	public static int peakElement(int[] arr, int n) {
		if (n == 1) {
			return 0;
		}
		if (arr[n - 1] > arr[n - 2]) {
			return n - 1;
		}
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
				return i;
		}

		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 2 };
		int n = arr.length;
		int res = peakElement(arr, n);
		System.out.println("Peak Element is::" + res);

	}

}
