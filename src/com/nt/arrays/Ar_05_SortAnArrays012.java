package com.nt.arrays;

public class Ar_05_SortAnArrays012 {

	public static void sort012(int a[], int n) {

		int low = 0;
		int mid = 0;
		int high = n - 1;

		for (int i = 0; i < n; i++) {
			while (mid <= high) {
				if (a[mid] == 0) {
					int temp = a[mid];
					a[mid] = a[low];
					a[low] = temp;
					low++;
					mid++;
				} else if (a[mid] == 1) {
					mid++;
				} else {
					int temp = a[high];
					a[high] = a[mid];
					a[mid] = temp;
					high--;
				}
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 0, 2, 1, 2, 0 };
		sort012(arr, arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}

}
