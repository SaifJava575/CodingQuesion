package com.nt.matrix;

public class Mt_10_FindWhetherPathExist {

	public static boolean findPath(int[][] grid, boolean vis[][], int i, int j) {
		if (i < 0 || j >= grid[0].length || i >= grid.length || j < 0 || grid[i][j] == 0 || vis[i][j] == true) {
			return false;
		}
		if (grid[i][j] == 2) {
			return true;
		}

		vis[i][j] = true;

		boolean d1 = findPath(grid, vis, i - 1, j);
		boolean d2 = findPath(grid, vis, i + 1, j);
		boolean d3 = findPath(grid, vis, i, j - 1);
		boolean d4 = findPath(grid, vis, i, j + 1);

		return d1 || d2 || d3 || d4;
	}

	// Function to find whether a path exists from the source to destination.
	public static boolean isPossible(int[][] grid) {
		int n = grid.length;
		boolean vis[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					return findPath(grid, vis, i, j);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int M[][] = { { 0, 3, 1, 0 }, { 3, 0, 3, 3 }, { 2, 3, 0, 3 }, { 0, 3, 3, 3 } };
      if(isPossible(M))
    	  System.out.println("Yes");
      else 
    	  System.out.println("No");
	}

}
