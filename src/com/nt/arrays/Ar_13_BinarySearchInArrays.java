package com.nt.arrays;

public class Ar_13_BinarySearchInArrays {

	public static int binarysearch(int arr[], int n, int k) {
		int s = 0, e = n - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] > k)
				e = mid - 1;
			else if (arr[mid] < k)
				s = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length, k = 4;
		int res = binarysearch(arr, n, k);
		System.out.println("The searching element is::" + res);

	}

}
