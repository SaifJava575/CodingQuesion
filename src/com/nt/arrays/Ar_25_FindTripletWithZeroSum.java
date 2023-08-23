package com.nt.arrays;

import java.util.Arrays;

public class Ar_25_FindTripletWithZeroSum {

	public static boolean findTriplets(int arr[], int n) {

		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			int sum = 0;
			while (j < k) {
				sum = arr[i] + arr[j] + arr[k];
				if (sum == 0)
					return true;
				else if (sum > 0)
					k--;
				else
					j++;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, -1, -3, 2 };
		if (findTriplets(arr, arr.length))
			System.out.println("1");
		else
			System.out.println("0");
	}

}
