package com.nt.advanceddsa;

import java.util.Arrays;

public class Ad_18_ArrayPartitioned {

	// T(C)=O(N * Log(N)) and S(C)=O(N)
	public static boolean partitionArray(int N, int K, int M, int[] A) {
		Arrays.sort(A);
		return rec(0, A, K, M);
	}

	static boolean rec(int start, int[] A, int K, int M) {
		int n = A.length;
		if (start >= n)
			return true;
		for (int i = start + K - 1; i < n; i++) {
			if ((A[i] - A[start]) > M)
				return false;
			if (rec(i + 1, A, K, M))
				return true;

		}
		return false;
	}

	public static void main(String[] args) {
		int K = 2;
		int M = 3;
		int A[] = { 8, 3, 9, 1, 2 };
		int N = A.length;
		if (partitionArray(N, K, M, A))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
