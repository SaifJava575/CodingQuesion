package com.nt.matrix;

public class Mt_02_RowWithMatrix1s {

	// T(c)=O(N+M) and S(C)=O(1)
	public static int rowWithMax1s(int arr[][], int n, int m) {
		int cnt = 0, max = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					cnt++;
			}
			if (cnt > max) {
				max = cnt;
				index = i;
			}
			cnt = 0;
		}
		if (max == 0)
			return -1;
		return index;
	}

	public static void main(String[] args) {
		int Arr[][] = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		int r = 4, c = 4;
		int response = rowWithMax1s(Arr, r, c);
		System.out.println("The max 1's row is ::" + response);

	}

}
