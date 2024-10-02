package com.nt.advanceddsa;

public class Ad_22_MaxPrefixSumRange {

	// T(C)=O(N*Q) and S(C)=O(1)
	static long[] maxPrefixes(long a[], long L[], long R[], long N, long Q) {
		long[] ans = new long[(int) Q];
		for (int i = 0; i < Q; i++) {
			long max = -999999999;
			long sum = 0;
			for (int j = (int) L[i]; j <= (int) R[i]; j++) {
				sum = sum + a[j];
				max = (max < sum) ? sum : max;
			}
			ans[i] = max;
		}
		return ans;
	}

	public static void main(String[] args) {
		long a[] = { -1, 2, 3, -5 };
		long l[] = { 0, 3 };
		long R[] = { 3, 3 };
		long Q = 2;
		long response[] = maxPrefixes(a, l, R, a.length, Q);
		for (long val : response) {
			System.out.print(val + " ");
		}

	}

}
