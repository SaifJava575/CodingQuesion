package com.nt.dp;

import java.util.Arrays;

public class Dp_02_CoinChanges {
	
	public static long count(int coins[], int n, int sum) {
		long[] table = new long[sum + 1];
        Arrays.fill(table, 0);     
        table[0] = 1;

        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];
 
        return table[sum];
    }
	
	public static long count1(int coins[], int N, int sum) {
        Arrays.sort(coins);
        long[][] dp = new long[N+1][sum+1];
        for(int i=0;i<=N;i++) dp[i][0] = 1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1] > j) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        for(int i=0;i<N;i++){
            if(coins[i] > 0) break;
            dp[N][sum] *= 2;
        }
        return dp[N][sum];
    }

	public static void main(String[] args) {
		int coins[] = {1,2,3};
		int n=coins.length,sum=4;
		long response=count1(coins, n, sum);
		System.out.println("Expected output is ::"+response);

	}

}
