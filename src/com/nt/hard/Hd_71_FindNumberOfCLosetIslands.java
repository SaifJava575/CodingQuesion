package com.nt.hard;

public class Hd_71_FindNumberOfCLosetIslands {

	// T(C)=O(N*M) and S(C)=O(N*M)
	public static int closedIslands(int[][] matrix, int N, int M) {
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1)
					dfs(matrix, i, j);

		int count = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 1) {
					dfs(matrix, i, j);
					count++;
				}

		return count;
	}

	public static void dfs(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1) 
			return;
		matrix[i][j] = 0;
		dfs(matrix, i + 1, j);
		dfs(matrix, i - 1, j);
		dfs(matrix, i, j + 1);
		dfs(matrix, i, j - 1);
	}

	public static void main(String[] args) {

		int mat[][] = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 1, 0 }, { 1, 0, 0, 0, 0, 1, 0, 1 } };
		int N = mat.length;
		int M = mat[0].length;
		int response = closedIslands(mat, N, M);
		System.out.println("The Closet islands number is::" + response);

	}

}
