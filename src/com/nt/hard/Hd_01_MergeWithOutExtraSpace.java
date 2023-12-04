package com.nt.hard;

import java.util.Arrays;

public class Hd_01_MergeWithOutExtraSpace {

	// T(C)= O((n+m) log(n+m)) and S(C)=O(1)
	public static void merge(long arr1[], long arr2[], int n, int m) {

		long res[] = new long[n + m];
		long a[] = new long[n];
		long b[] = new long[m];
		int j = 0;
		for (int i = 0; i < n; i++) {
			res[j] = arr1[i];
			j++;
		}
		for (int i = 0; i < m; i++) {
			res[j] = arr2[i];
			j++;
		}

		Arrays.sort(res);

		for (int i = 0; i < n; i++)
			a[i] = res[i];
		int c = 0;
		for (int i = m - 1; i < res.length; i++) {
			b[c] = res[i];
			c++;
		}

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

		System.out.println();
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");

	}

	public static void main(String[] args) {
		long arr1[] = { 1, 3, 5, 7 };
		long arr2[] = { 0, 2, 6, 8, 9 };
		int n = arr1.length;
		int m = arr2.length;
		merge(arr1, arr2, n, m);

	}

}
