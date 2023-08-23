package com.nt.matrix;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Mt_09_MedianInRowWiseSortedMatrix {

	//T(C)=O(32 * R * log(C))  and S(C)=O(1)
	static int median(int matrix[][], int R, int C) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = R * C;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				pq.add(matrix[i][j]);
		}
		int m = n / 2;
		while (m-- > 0)
			pq.poll();
		return pq.poll();
	}

	//T(C)=O(32 * R * log(C))  and S(C)=O(n)
	static int median1(int matrix[][], int R, int C) {
		int n = R * C;
		int arr[] = new int[n];
		int r=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				arr[r++]=matrix[i][j];
			
		}
		Arrays.sort(arr);
		int len = arr.length;
		int median = arr[len / 2];
		return median;
	}

	public static void main(String[] args) {
		int R = 3, C = 3;
		int mat[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		int response = median1(mat, R, C);
		System.out.println("The median element is::" + response);

	}

}
