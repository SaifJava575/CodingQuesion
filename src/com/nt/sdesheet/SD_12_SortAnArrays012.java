package com.nt.sdesheet;

public class SD_12_SortAnArrays012 {

	// T(c)=O(N) and S(C)=O(1)
	public static void sort012(int a[], int n) {
		int low = 0;
		int mid = 0;
		int high = n - 1;
		for (int i = 0; i < n; i++) {
			while (mid <= high) {
				if (a[mid] == 0) {
					int temp = a[mid];
					a[low] = a[mid];
					a[mid] = temp;
					mid++;
					low++;
				} else if (a[mid] == 1)
					mid++;
				else {
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
		int n = arr.length;
		sort012(arr, n);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i]+" ");

	}

}
