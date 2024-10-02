package com.nt.sdesheet;

public class SD_18_TrappingRainWater {

	// T(c)=O(n) and S(C)=O(1)
	static long trappingWater(int arr[], int n) {
		int left = 0;
		int right = n - 1;
		long maxLeft = 0;
		long maxRight = 0;
		long res = 0;

		while (left <= right) {

			if (arr[left] <= arr[right]) {

				if (arr[left] >= maxLeft)
					maxLeft = arr[left];
				else
					res += maxLeft - arr[left];
				left++;
			}

			else {

				if (arr[right] >= maxRight)
					maxRight = arr[right];
				else
					res += maxRight - arr[right];
				right--;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 0, 0, 2, 0, 4 };
		long response = trappingWater(arr, arr.length);
		System.out.println("Trapping Water " + response);
	}

}
