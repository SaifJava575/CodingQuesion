package com.nt.hard;

public class Hd_12_SolveTheSudukoProblem {

	// T(C)=O(9^N*N) and S(C)=O(N*N)
	public static boolean SolveSudoku(int grid[][]) {
		return SodukoHelper(grid, 0, 0);
	}

	static boolean SodukoHelper(int grid[][], int row, int col) {
		if (row == 9)
			return true; // BASE CASE-> IF ROW IS EQUAL TO 9 THAT MEANS THAT 0 TO 8 ROWS ARE FILLED
							// SUCCESSFULLY ANF GRID IS COMPLETED
		int nextrow = row; // NEXT ROW
		int nextcol = col + 1; // NEXT COL
		if (col + 1 == 9) {
			nextrow = row + 1; // UPDATING ROW ONLY IF ALL COLUMNS ARE TRAVERSED
			nextcol = 0;
		}
		if (grid[row][col] != 0)
			return SodukoHelper(grid, nextrow, nextcol); // IF ANY DIGIT IS ALREADY THERE CHECK FOR NEXT ROW OR COLUMN
		for (int digit = 1; digit <= 9; digit++) {
			if (isSafe(grid, row, col, digit)) { // CHECKING SAFE CONDITION FOR PRESENT ROW OR COLUMN FOR A PARTICULAR
													// DIGIT
				grid[row][col] = digit;
				if (SodukoHelper(grid, nextrow, nextcol)) { // CALLING RECURSIVELY FOR NEXT ROW OR COLUMN
					return true;
				}
				grid[row][col] = 0; // BACKTRACKING STEP--> AT SOME POINT THE DIGIT PLACED IT NOT CORRECT SO IT WILL
									// AGAIN SET TO 0 DURING RETURNING OF CALLS FROM CALL STACK
			}

		}
		return false;
	}

	static boolean isSafe(int grid[][], int row, int col, int digit) {
		for (int i = 0; i <= 8; i++) {
			if (grid[i][col] == digit)
				return false;
		}
		for (int j = 0; j <= 8; j++) {
			if (grid[row][j] == digit)
				return false;
		}
		int sr = (row / 3) * 3;
		int sc = (col / 3) * 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (grid[i][j] == digit)
					return false;
			}
		}
		return true;
	}

	public static void printGrid(int grid[][]) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (i == grid.length - 1 && j == grid.length - 1)
					System.out.print(grid[i][j]);
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		if (SolveSudoku(grid)) {
			System.out.println("Exist Valid suduko is ::");
			printGrid(grid);
		} else {
			System.out.println("Does not Exist Valid suduko is ::");
			printGrid(grid);
		}

	}

}
