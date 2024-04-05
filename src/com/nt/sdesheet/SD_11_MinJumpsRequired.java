package com.nt.sdesheet;

public class SD_11_MinJumpsRequired {

	//T(C)=O(N)   and S(C)=O(1)
	public static int minJumps(int[] arr) {
		int totalJump = 0;
		int destination = arr.length - 1;
		int coverage = 0;
		int lastJumpIdx = 0;

		if (arr.length == 1)
			return 0;
		for (int i = 0; i < arr.length; i++) {
			coverage = Math.max(coverage, i + arr[i]);

			if (i == lastJumpIdx) {
				lastJumpIdx = coverage;
				totalJump++;

				if (coverage >= destination) {
					return totalJump;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int response = minJumps(arr);
		System.out.println("The min Jumps Required are::" + response);
	}
}
