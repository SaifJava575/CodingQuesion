package com.nt.advanceddsa;

public class Ad_24_SmallestSubArraysGCD {

	public static int findSmallestSubArr(int[] arr, int n, int g) {
		// code here
		for (int i : arr)
			if (i == g)
				return 1;
		for (int i = 1; i < n; i++) {
			int a = gcd(arr[i - 1], arr[i]);
			if (a == g)
				return 2;
		}

		return -1;
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int arr[] = { 6, 9, 7, 10, 12, 24, 36, 27 };
		int n = arr.length;
		int g = 3;
		int resposne = findSmallestSubArr(arr, n, g);
		System.out.println(resposne);

	}

}
