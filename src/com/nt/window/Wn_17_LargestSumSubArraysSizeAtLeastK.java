package com.nt.window;

public class Wn_17_LargestSumSubArraysSizeAtLeastK {

	// T(c)= O(N) and S(C)= O(N)
	public static long maxSumWithK(long a[], long N, long K) {
		int n = (int) N;
		int k = (int) K;
		long sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}

		long ans = sum;

		long prev = 0;

		long prev_sum = 0;

		for (int i = k; i < n; i++) {
			prev_sum += a[i - k];

			prev = Math.min(prev, prev_sum);

			sum += a[i];

			if (sum - prev > ans) {
				ans = sum - prev;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		long arr[] = { -4, -2, 1, -3 };
		long n = arr.length;
		long k = 2;
		long response = maxSumWithK(arr, n, k);
		System.out.println("Max Sum With Subarray is " + response);
	}

}
