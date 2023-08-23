package com.nt.hash;

import java.util.Arrays;

public class HM_02_FIndTripletWithZeroSum {

	// T(C)=O(n^2) and S(c)=O(1)
	public static boolean findTriplets(int arr[], int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n-2; i++) {
			int l = i + 1;
			int r = n - 1;
			int x = arr[i];
			while (l < r) {
				if (x + arr[l] + arr[r] == 0)
					return true;
				else if (x + arr[l] + arr[r] < 0)
					l++;
				else
					r--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 0, -1, 2, -3, 1 };
		if (findTriplets(arr, arr.length))
			System.out.println("Find Triplets");
		else
			System.out.println("No finds Triplets");
	}

}
