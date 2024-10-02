package com.nt.ninja;

public class NJ_03_NinjaTraing {

	public static int ninjaTraining(int n, int points[][]) {

		int m=points[0].length;
		int max=Integer.MIN_VALUE;
		int coin=0;
		int pos=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(max<points[i][j]) {
					max=points[i][j];
					pos=j;
				}			
			}
			coin+=max;
			max=0;
			pos=0;
		}
		return coin;
	}

	public static void main(String[] args) {
		int positiion[][] = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
		int res = ninjaTraining(positiion.length, positiion);
		System.out.println("The max coin can collect :"+res);
	}

}