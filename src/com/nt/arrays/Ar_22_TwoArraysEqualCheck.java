package com.nt.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Ar_22_TwoArraysEqualCheck {

	public static boolean check(int A[], int B[], int N) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(A[i]);
		for (int i = 0; i < N; i++) {
			if (list.contains(B[i]))
				list.remove(B[i]);
		}
		if (list.isEmpty())
			return true;

		return false;
	}

	public static boolean check(long A[], long B[], int N) {
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i])
				return false;
		}
		//Arrays.equals(A, B);

		return true;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 5 };
		int B[] = { 2, 1, 5 };
		int n = A.length;
		if (check(A, B, n))
			System.out.println("Two Array are equal");
		else
			System.out.println("Two Arrays are not equal");
	}

}
