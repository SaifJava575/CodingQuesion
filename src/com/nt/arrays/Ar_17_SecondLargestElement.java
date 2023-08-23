package com.nt.arrays;

import java.util.Arrays;

public class Ar_17_SecondLargestElement {

	public static int print2largest(int arr[], int n) {
		Arrays.sort(arr);
		return arr[n - 2];
	}

	static int print2largest1(int arr[], int n) {
		int largest = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > largest)
				largest = arr[i];

		}
		int second_lar = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > second_lar && arr[i] != largest) {
				second_lar = arr[i];
			}
		}
		return second_lar;

	}

	public static void main(String[] args) {
		int arr[] = { 12, 35, 1, 10, 34, 1 };
		int res = print2largest1(arr, arr.length);
		System.out.println("Second Largest Element is::" + res);
	}

}
