package com.nt.hard;

import java.util.PriorityQueue;

public class Hd_20_MinmumCostPath {

	// T(C)=O(n2*log(n)) and S(c)= O(n2)
	public static int minimumCostPath(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		int[][] minPath = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				minPath[i][j] = Integer.MAX_VALUE;
			}
		}

		pq.add(new int[] { 0, 0, grid[0][0] });
		minPath[0][0] = grid[0][0];

		while (pq.size() > 0) {
			int row = pq.peek()[0];
			int col = pq.peek()[1];
			int wt = pq.peek()[2];
			pq.poll();

			if (row == n - 1 && col == m - 1) {
				break;
			}

			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };

			for (int i = 0; i < 4; i++) {
				int x = row + dx[i];
				int y = col + dy[i];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (minPath[x][y] > wt + grid[x][y]) {
						pq.add(new int[] { x, y, wt + grid[x][y] });
						minPath[x][y] = wt + grid[x][y];
					}
				}
			}
		}

		return minPath[n - 1][m - 1];
	}

	public static void main(String[] args) {
		int grid[][] = { { 9, 4, 9, 9 }, { 6, 7, 6, 4 }, { 8, 3, 3, 7 }, { 7, 4, 9, 10 } };
		int response = minimumCostPath(grid);
		System.out.println("Minimum Cost Path is :"+response);

	}

}
