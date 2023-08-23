package com.nt.matrix;

public class Mt_03_SearchInMatrix {

	public static int matSearch(int mat[][], int N, int M, int X) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == X)
					return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int mat[][] = { { 3, 30, 38 }, { 44, 52, 54 }, { 57, 60, 69 } };
		int r=3,c=3;
		int response=matSearch(mat, r, c, 52);
		System.out.println("The  search element is::"+response);
	}

}
