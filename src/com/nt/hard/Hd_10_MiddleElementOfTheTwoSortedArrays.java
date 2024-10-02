package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;

public class Hd_10_MiddleElementOfTheTwoSortedArrays {

	static double medianOfArrays(int n, int m, int a[], int b[]) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (Integer val : a)
			arr.add(val);
		for (Integer val : b)
			arr.add(val);
		Collections.sort(arr);
		return findMedianElement(arr, arr.size());

	}

	public static double findMedianElement(ArrayList<Integer> arr, int x) {
		if (x == 0)
			throw new IllegalArgumentException("Arrays is Empty");
		int middleIndex = x / 2;
		if (x % 2 == 1)
			return arr.get(middleIndex);
		else {
			int middleEle1 = arr.get(middleIndex - 1);
			int middleEle2 = arr.get(middleIndex);
			return (middleEle1 + middleEle2) / 2.0;
		}

	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 9 };
		int b[] = { 2, 3, 6, 7 };
		double response = medianOfArrays(a.length, b.length, a, b);
		System.out.println("The median Element of two sorted Arrays ::" + response);

	}

}
