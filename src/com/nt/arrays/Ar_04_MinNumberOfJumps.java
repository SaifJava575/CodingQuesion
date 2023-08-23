package com.nt.arrays;

public class Ar_04_MinNumberOfJumps {

	// T(C)=O(N) and S(C)=O(1)
	public static int minJumps(int[] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 1; i < n; i++)
			arr[i] = Math.max(arr[i] + i, arr[i - 1]);

		int i = 0;
		while (i < n - 1) {
			if (arr[i] <= i)
				return -1;
			i = arr[i];
			count++;
		}
		return count;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int res = minJumps(arr);
		System.out.println("min number of Jumps required::" + res);

	}

}
