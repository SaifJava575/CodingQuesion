package com.nt.window;

public class Wn_21_MaximumSumOfSubArrays {

	//T(c)=O(N)  and S(C)=O(1)
	static long findMaxSubarraySum(long arr[], int N, int X) {
		long sum = 0, ans = 0;
		int j = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum > X) {
				while (sum > X) {
					sum -= arr[j];
					j++;
				}
			}
			if (sum < X || sum == X) {
				if (sum > ans)
					ans = sum;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		long arr[] = { 1, 2, 3, 4, 5 };
		long response = findMaxSubarraySum(arr, arr.length, 11);
		System.out.println(response);
	}

}
