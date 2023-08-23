package com.nt.graph;

public class Gr_18_PathExistingCheck {

	public static boolean isPossible(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean vis[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == 1)
					return findPath(grid, i, j, vis);
		}
		return false;

	}

	public static boolean findPath(int grid[][], int row, int col, boolean vis[][]) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0
				|| vis[row][col] == true)
			return false;
		if (grid[row][col] == 2)
			return true;
		vis[row][col] = true;
		boolean d1 = findPath(grid, row - 1, col, vis);
		boolean d2 = findPath(grid, row + 1, col, vis);
		boolean d3 = findPath(grid, row, col - 1, vis);
		boolean d4 = findPath(grid, row, col + 1, vis);
		return d1 || d2 || d3 || d4;

	}

	public static void main(String[] args) {
		int matrix[][] = { { 3, 0, 3, 0, 0 }, { 3, 0, 0, 0, 3 }, { 3, 3, 3, 3, 3, 3 }, { 0, 2, 3, 0, 0 },
				{ 3, 0, 0, 1, 3 } };
		
		if(isPossible(matrix))
			System.out.println("Path exist this graph");
		else
			System.out.println("Path is not exist this graph");

	}

}
