package com.nt.hash;

import java.util.Arrays;

public class HM_03_TwoArraysEqualCheck {

	public static boolean check(long A[], long B[], int N) {
		Arrays.sort(A);
		Arrays.sort(B);
		int count = 0;
		for (int i = 0; i < N; i++)
			if (A[i] == B[i])
				count++;
		if (count == N)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		long A[] = { 1, 2, 5, 4, 0 };
		long B[] = { 2, 4, 5, 0, 1 };
		if (check(A, B, A.length))
			System.out.println("Equals");
		else
			System.out.println("Not Equals");
	}

}
