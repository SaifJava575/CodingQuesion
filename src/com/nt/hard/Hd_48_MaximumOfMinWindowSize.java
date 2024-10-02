package com.nt.hard;

import java.util.ArrayDeque;

public class Hd_48_MaximumOfMinWindowSize {

	//T(C)=O(N)  and S(C)=O(N)
	static int[] maxOfMin(int[] arr, int n) {
		ArrayDeque<Integer> st = new ArrayDeque<>();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				int index = st.pop();
				int range = (!st.isEmpty()) ? i - st.peek() - 1 : i;
				ans[range - 1] = ans[range - 1] > arr[index] ? ans[range - 1] : arr[index];
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			int index = st.pop();
			int range = (!st.isEmpty()) ? n - st.peek() - 1 : n;
			ans[range - 1] = ans[range - 1] > arr[index] ? ans[range - 1] : arr[index];
		}

		for (int i = n - 2; i >= 0; i--) {
			if (ans[i] < ans[i + 1])
				ans[i] = ans[i + 1];
		}

		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {10,20,30,50,10,70,30};
		int response[]=maxOfMin(arr, arr.length);
		System.out.println("Expected Output is ::");
		for(Integer val:response)
			System.out.print(val+" ");

	}

}
