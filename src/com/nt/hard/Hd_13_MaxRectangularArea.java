package com.nt.hard;

import java.util.Stack;

public class Hd_13_MaxRectangularArea {

	// T(c)=O(n*m) and S(C)= O(m)
	public static int maxArea(int M[][], int n, int m) {
		long[] height = new long[m];
		long maxArea = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (M[i][j] == 1)
					height[j]++;
				else
					height[j] = 0;
			}
			long area = getMaxArea(height, Long.valueOf(m));
			maxArea = Math.max(maxArea, area);
		}
		return (int) maxArea;
	}

	public static long getMaxArea(long hist[], long n) {
		long res = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			long current = 0;
			while (!st.empty() && hist[st.peek()] >= hist[i]) {
				int top = st.pop();
				current = hist[top] * ((st.empty()) ? i : (i - st.peek() - 1));
				res = Math.max(res, current);
			}
			st.push(i);
		}

		while (!st.empty()) {
			long current = 0;
			int top = st.pop();
			current = hist[top] * ((st.empty()) ? n : (n - st.peek() - 1));
			res = Math.max(res, current);
		}
		return res;
	}
	// TC()

	public static void main(String[] args) {
		int M[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int n = M.length;
		int m = M[0].length;

		int response = maxArea(M, n, m);
		System.out.println("The max Rectangular Area is ::" + response);

	}

}
