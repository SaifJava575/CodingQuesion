package com.nt.sdesheet;

import java.util.Stack;

public class SD_23_StockSpanProblem {

	// T(C)=O(n) and S(C)=O(n)
	public static int[] calculateSpan(int price[], int n) {
		int arr[] = new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for (int i = 0; i < n; i++) {
			while (st.size() != 0 && price[i] >= price[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0)
				arr[i] = i + 1;
			else
				arr[i] = i - st.peek();

			st.push(i);
		}
		return arr;
	}

	public static void main(String[] args) {
		int price[] = { 100, 80, 60, 70, 60, 75, 85 };
		int n = price.length;
		int response[] = calculateSpan(price, n);
		System.out.println("Stock Span Series are :: ");
		for (int i = 0; i < response.length; i++) {
			System.out.print(response[i] + " ");
		}

	}

}
