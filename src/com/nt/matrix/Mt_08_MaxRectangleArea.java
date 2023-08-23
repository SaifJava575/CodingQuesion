package com.nt.matrix;

import java.util.Stack;

public class Mt_08_MaxRectangleArea {

	//T(C)=O(n*m)  and S(C)=O(m)
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

	public static void main(String[] args) {

		int n = 4, m = 4;
		int M[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int response=maxArea(M, n, m);
		System.out.println("The max Rectangle Area is ::"+response);
	}

}
