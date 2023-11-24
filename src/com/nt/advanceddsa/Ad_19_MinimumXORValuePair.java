package com.nt.advanceddsa;

public class Ad_19_MinimumXORValuePair {

	static int minxorpair(int N, int nums[]) {
		int min = Integer.MAX_VALUE;
		if (N == 3) {
			min = Math.min(min, nums[0] ^ nums[2]);
		}

		for (int i = 0; i < nums.length - 1; i++) {
			min = Math.min(min, nums[i] ^ nums[i + 1]);
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = { 9, 5, 3 };
		int n = arr.length;
		int response = minxorpair(n, arr);
		System.out.println("Minimum Pair value is "+response);
	}

}
