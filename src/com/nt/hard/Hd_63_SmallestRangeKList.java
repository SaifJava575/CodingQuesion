package com.nt.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Hd_63_SmallestRangeKList {
	
	static class Node {
	    int data;
	    int row;
	    int col;

	    Node(int data, int i, int j) {
	        this.data = data;
	        row = i;
	        col = j;
	    }
	}

	// T(C)=O(n * k *log k) and S(c)= O(k)
	static int[] findSmallestRange(int[][] KSortedArray, int n, int k) {
		 PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
	        int maxi = Integer.MIN_VALUE;
	        int mini = Integer.MAX_VALUE;
	        for (int i = 0; i < k; i++) {
	            Node temp = new Node(KSortedArray[i][0], i, 0);
	            mini = Math.min(mini, temp.data);
	            maxi = Math.max(maxi, temp.data);
	            pq.add(temp);
	        }
	        int start = mini, end = maxi;
	        while (!pq.isEmpty()) {
	            Node temp = pq.poll();
	            mini = temp.data;
	            int row = temp.row;
	            int col = temp.col;
	            if (maxi - mini < end - start) {
	                start = mini;
	                end = maxi;
	            }
	            if (col + 1 < n) {
	                Node next = new Node(KSortedArray[row][col + 1], row, col + 1);
	                maxi = Math.max(maxi, KSortedArray[row][col + 1]);
	                pq.add(next);
	            } else {
	                break;
	            }
	        }
	        return new int[]{start, end};
	}

	public static void main(String[] args) {
		int N = 4, K = 3;
		int KSortedArray[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int response[] = findSmallestRange(KSortedArray, N, K);
		System.out.println("Smallest Range in K LIST is::   ");
		for (Integer val : response)
			System.out.print(val + " ");

	}

}
