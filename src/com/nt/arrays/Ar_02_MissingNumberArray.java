package com.nt.arrays;

public class Ar_02_MissingNumberArray {

	// T(c)=O(n) and S(C)=O(1)
	public static int missingNumber(int[] arr, int length) {
		int n = length + 1;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < length; i++) {
			sum -= arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 1, 2, 8, 3, 4, 7, 10, 5 };
		int n = arr.length;
		int res = missingNumber(arr, n);
		System.out.println(res);

	}

}
