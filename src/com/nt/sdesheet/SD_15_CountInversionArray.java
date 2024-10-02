package com.nt.sdesheet;

import java.util.ArrayList;

public class SD_15_CountInversionArray {

	// T(C)= O(NLogN). and S(C)=O(N)
	static long inversionCount(long arr[], long N) {
		if (N == 0 || N == 1)
			return 0;
		return mergeSort(arr, 0, N - 1);
	}

	static long mergeSort(long[] arr, long low, long high) {
		long count = 0;
		long mid = (low + high) / 2;

		if (low >= high)
			return count;
		count += mergeSort(arr, low, mid);
		count += mergeSort(arr, mid + 1, high);
		count += merge(arr, low, mid, high);

		return count;
	}

	static long merge(long[] arr, long low, long mid, long high) {

		long left = low;
		long right = mid + 1;
		long count = 0;

		ArrayList<Long> s = new ArrayList<>();

		while (left <= mid && right <= high) {

			if (arr[(int) left] <= arr[(int) right]) {
				s.add(arr[(int) left]);
				left++;
			} else if (arr[(int) left] > arr[(int) right]) {
				s.add(arr[(int) right]);
				count += (mid - left) + 1;
				right++;
			}

		}

		while (left <= mid) {
			s.add(arr[(int) left]);
			left++;

		}

		while (right <= high) {
			s.add(arr[(int) right]);
			right++;
		}

		for (int i = (int) low; i <= high; i++) {
			arr[i] = s.get(i - (int) low);
		}

		return count;
	}

	public static void main(String[] args) {
		long arr[] = { 2, 4, 1, 3, 5 };
		long N = arr.length;
		long response = inversionCount(arr, N);
		System.out.println("The Inversion Of Count is ::" + response);

	}

}
