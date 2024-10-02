package com.nt.hard;

import java.util.Arrays;

public class Hd_45_SmallestPositiveIntegers {

	static long smallestpositive(long[] array, int n) {
		long ans = 1;
		Arrays.sort(array);
		for (int i = 0; i < n; i++) {
			if (array[i] > ans)
				return ans;
			ans += array[i];
		}
		return ans;

	}

	static long smallestpositive1(long[] array, int N) {
		Arrays.sort(array);
		long result = 1;
		for (int i = 0; i < N && array[i] <= result; i++) {
			result += array[i];
		}
		return result;

	}

	public static void main(String[] args) {
		// long array[] = { 1, 10, 3, 11, 6, 15 };
		long array[] = { 1, 1, 1, 1, 1 };
		int n = array.length;
		long response = smallestpositive(array, n);
		System.out.println("The Expected Output is ::" + response);
	}

}
