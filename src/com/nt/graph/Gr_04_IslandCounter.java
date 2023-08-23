package com.nt.graph;

public class Gr_04_IslandCounter {
	
	
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) 
			return 0;

		int numIslands = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					numIslands++;
					dfs(i, j,grid);
				}
			}
		}

		return numIslands;
	}

	 public static void dfs(int i,int j,char[][] grid){
	        if(i<0 || i == grid.length || j<0 || j==grid[0].length || grid[i][j] == '0'){
	            return;
	        }
	        grid[i][j] = '0';
	        dfs(i-1,j,grid);
	        dfs(i-1,j+1,grid);
	        dfs(i,j+1,grid);
	        dfs(i+1,j+1,grid);
	        dfs(i+1,j,grid);
	        dfs(i+1,j-1,grid);
	        dfs(i,j-1,grid);
	        dfs(i-1,j-1,grid);
	    }
	 
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		int numIslands =numIslands(grid);

		System.out.println("Number of islands: " + numIslands);
	}
}
