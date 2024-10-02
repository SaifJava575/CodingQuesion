package com.nt.hard;

import java.util.Stack;

public class Hd_03_MaxRectangularAreaInHistogram {

	// T(C)=O(N) and S(C)=O(N)
	public static long getMaxArea(long hist[], long n) {
		long[] prevSmall = getPrevSmall(hist);
		long[] nextSmall = getNextSmall(hist);
		long maxArea = 0;
		for (int i = 0; i < n; i++) {
			long l = hist[i];
			long w = nextSmall[i] - prevSmall[i] - 1;
			long newArea = l * w;
			maxArea = Math.max(maxArea, newArea);
		}
		return maxArea;
	}

	public static long[] getPrevSmall(long[] arr) {
		long[] prevSmall = new long[arr.length];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] >= arr[i])
				s.pop();
			if (s.isEmpty())
				prevSmall[i] = -1;
			else
				prevSmall[i] = s.peek();
			s.push(i);
		}
		return prevSmall;
	}

	public static long[] getNextSmall(long[] arr) {

		long[] nextSmall = new long[arr.length];

		Stack<Integer> s = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!s.isEmpty() && arr[s.peek()] >= arr[i])
				s.pop();

			if (s.isEmpty())
				nextSmall[i] = arr.length;
			else
				nextSmall[i] = s.peek();

			s.push(i);
		}

		return nextSmall;
	}

	public static void main(String[] args) {
		long arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		long lenght = arr.length;
		long response = getMaxArea(arr, lenght);
		System.out.println("Max Histogram Area is ::" + response);
	}

}
