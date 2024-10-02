package com.nt.sdesheet;

public class SD_19_SecondLargestElement {

	// T(c)=O(N) and S(C)=O(1)
	static int print2largest(int arr[], int n) {
		int maxf = -1;
		int maxs = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > maxf)
				maxf = arr[i];
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] > maxs && arr[i] != maxf)
				maxs = arr[i];
		}
		return maxs;
	}

	public static void main(String[] args) {
		int Arr[] = { 12, 35, 1, 10, 34, 1 };
		int n = Arr.length;
		System.out.println("Second Largest Element is ::" + print2largest(Arr, n));

	}

}
