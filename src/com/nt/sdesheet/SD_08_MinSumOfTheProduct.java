package com.nt.sdesheet;

import java.util.Arrays;

public class SD_08_MinSumOfTheProduct {

	public static long minValue(long a[], long b[], long n) {
		Arrays.sort(a);
		Arrays.sort(b);

		long s = 0, e = n - 1, sum = 0;
		while (s < n)
			sum = sum + (a[(int) s++] * b[(int) e--]);

		return sum;
	}

	public static void main(String[] args) {
		long A[] = { 6, 1, 9, 5, 4 };
		long B[] = { 3, 4, 8, 2, 4 };
		long n = A.length;
		long response = minValue(A, B, n);
		System.out.println("THE SUM OF THE MIN VALUE IS::" + response);
	}

}
