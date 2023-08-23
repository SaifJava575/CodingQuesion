package com.nt.graph;

import java.util.LinkedList;
import java.util.Queue;

class Triple {
	int row;
	int col;
	int distance;

	public Triple(int row, int col, int distance) {
		this.row = row;
		this.col = col;
		this.distance = distance;
	}
}

public class Gr_22_DIstanceOfNearestCell {

	public static int[][] nearest(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] visited = new int[m][n];
		Queue<Triple> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					visited[i][j] = 0;
					queue.offer(new Triple(i, j, 0));
				} else {
					visited[i][j] = -1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Triple triple = queue.poll();
			int row = triple.row;
			int col = triple.col;
			int distance = triple.distance;

			int[] drow = { -1, 0, 1, 0 };
			int[] dcol = { 0, 1, 0, -1 };

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];
				if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == -1) {
					queue.offer(new Triple(nrow, ncol, distance + 1));
					visited[nrow][ncol] = distance + 1;
				}
			}
		}

		return visited;

	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
		int response[][]=nearest(mat);
		for(int val[]:response) {
			for(int i:val)
				System.out.print(i+" ");
			System.out.println();
		}
		

	}

}
