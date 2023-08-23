package com.nt.matrix;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int i = 0;
	int j = 0;
	int time = 0;

	Pair(int i, int j, int time) {
		this.i = i;
		this.j = j;
		this.time = time;
	}
}

public class Mt_04_RottenOrangesMatrix {

	public static boolean isSafe(int[][] grid, int i, int j) {
		return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1);
	}

	public static int orangesRotting(int[][] grid) {
		int[] xDir = { 0, 0, -1, 1 };
		int[] yDir = { -1, 1, 0, 0 };
		int n = grid.length;
		int m = grid[0].length;
		int oranges = 0;
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
				} else if (grid[i][j] == 1) {
					oranges++;
				}
			}
		}
		while (queue.size() > 0) {
			Pair p = queue.poll();
			int x = p.i;
			int y = p.j;
			int t = p.time;
			for (int k = 0; k < 4; k++) {
				int newRow = x + xDir[k];
				int newCol = y + yDir[k];
				if (isSafe(grid, newRow, newCol)) {
					grid[newRow][newCol] = 2;
					queue.add(new Pair(newRow, newCol, t + 1));
					oranges--;
				}
				if (oranges == 0)
					return t + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int grid[][] = {{0,1,2},{0,1,2},{2,1,1}};
		int response=orangesRotting(grid);
		System.out.println("The Orange Rotating element is::"+response);
	}

}
