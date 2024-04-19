package com.nt.sdesheet;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SD_13KthSmallestElement {

	// T(C)=O(n*logn) and S(c)=O(1)
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

	public static int kthSmallest1(int[] arr, int l, int r, int k) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		for (int num : arr)
			minheap.add(num);
		for (int i = 0; i < k - 1; i++)
			minheap.poll();
		return minheap.peek();
	}

	// T(c)=O(n) and S(c)=O(1)
	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 20, 15 };
		int K = 4;
		int response = kthSmallest1(arr, 0, 0, K);
		System.out.println("The kth Smallest Element is ::" + response);
	}

}
