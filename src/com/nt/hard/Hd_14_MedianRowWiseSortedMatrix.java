package com.nt.hard;

import java.util.Arrays;

public class Hd_14_MedianRowWiseSortedMatrix {

	//T(C)=O(32 * R * log(C))  and S(c)=O(1)
	public static int median(int matrix[][], int R, int C) {
		int n = R * C;
		int arr[] = new int[n];
		int r = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				arr[r++] = matrix[i][j];
		Arrays.sort(arr);
		int length = arr.length;
		int median = length / 2;
		return arr[median];

	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		int R = matrix.length;
		int C = matrix[0].length;
		int response = median(matrix, R, C);
		System.out.println("The media of the Matrix is ::" + response);

	}

}
