package com.nt.matrix;

public class Mt_12_SearchInRowColumnSortedMatrix {

	static boolean search(int matrix[][], int n, int m, int x) {
		int len = n * m;
		int arr[] = new int[len];
		int r = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				arr[r++] = matrix[i][j];
		}
		for (int i = 0; i < len; i++) {
			if (arr[i] == x)
				return true;
		}
		return false;
	}

	// T(c)=O(N + M)  and S(C)=O(1)
	static boolean search1(int arr[][], int n, int m, int target) {
		int row = 0;
		int col = n - 1;

		while (col >= 0 && row <= n - 1) {

			if (arr[row][col] > target) {
				col--;
			} else if (arr[row][col] < target)
				row++;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 30, 38 }, { 36, 43, 60 }, { 40, 51, 69 } };
		int row = matrix.length, col = matrix[0].length, x = 68;
		if (search1(matrix, row, col, x))
			System.out.println("Search Elemenet is exist");
		else
			System.out.println("Search element is not exist");
	}

}
