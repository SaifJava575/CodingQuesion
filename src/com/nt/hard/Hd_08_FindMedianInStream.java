package com.nt.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class Hd_08_FindMedianInStream {

	static PriorityQueue<Integer> right = new PriorityQueue();
	static PriorityQueue<Integer> left = new PriorityQueue(Collections.reverseOrder());

	//T(C)=O(nlogn)  and S(C)=O(n)
	public static void insertHeap(int x) {
		if (left.size() == 0 || x < left.peek()) {
			left.add(x);
		} else {
			right.add(x);
		}
		balanceHeaps();
	}

	// Function to balance heaps.
	public static void balanceHeaps() {
		if (left.size() > right.size() + 1) {
			right.add(left.remove());
		}
		if (left.size() < right.size()) {
			left.add(right.remove());
		}
	}

	// Function to return Median.
	public static double getMedian() {
		if (left.size() == right.size()) {
			return (left.peek() + right.peek()) / 2.0;
		} else {
			return left.peek();
		}
	}

	public static void main(String[] args) {
		int X[] = { 5, 15, 1, 3 };
		for (int i = 0; i < X.length; i++) {
			insertHeap(X[i]);
			double response = getMedian();
			System.out.print(response+" ");
		}
	}

}
