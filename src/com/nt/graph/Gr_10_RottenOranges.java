package com.nt.graph;

public class Gr_10_RottenOranges {

	public static int orangesRotting(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2)
					dfs(i, j, grid, 2);
			}
		}

		int minutes = 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					return -1;
				else if (grid[i][j] >= 2)
					minutes = Math.max(minutes, grid[i][j]);
			}
		}
		return minutes - 2;
	}

	public static void dfs(int i, int j, int[][] grid, int m) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0
				|| (grid[i][j] > 1 && grid[i][j] < m))
			return;

		grid[i][j] = m;
		dfs(i - 1, j, grid, m + 1);
		dfs(i, j + 1, grid, m + 1);
		dfs(i + 1, j, grid, m + 1);
		dfs(i, j - 1, grid, m + 1);
	}

	public static void main(String[] args) {
		int grid[][] = new int[][] { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
		int response=orangesRotting(grid);
		System.out.println("The oranges Rotating is "+response);
	}

}
