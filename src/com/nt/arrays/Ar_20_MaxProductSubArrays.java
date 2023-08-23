package com.nt.arrays;

public class Ar_20_MaxProductSubArrays {

	//T(c)=O(n) and S(c)=O(1)
	public static int maxProduct(int[] arr, int n) {
		int maxLeft = 1, maxRight = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (maxLeft == 0)
				maxLeft = 1;
			if (maxRight == 0)
				maxRight = 1;
			maxLeft *= arr[i];
			maxRight *= arr[n - 1 - i];
			max = Math.max(max, Math.max(maxLeft, maxRight));
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, -1, 0 };
		int n = arr.length;
		int res = maxProduct(arr, n);
		System.out.println("Max Sub Product is::" + res);
	}

}
