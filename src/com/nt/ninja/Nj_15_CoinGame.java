package com.nt.ninja;

public class Nj_15_CoinGame {
    public static int maxCoins(int[] coins, int numberOfCoins) {
        // DP table to store the results
        int[][] dp = new int[numberOfCoins][numberOfCoins];
        
        // Fill the dp table
        for (int gap = 0; gap < numberOfCoins; gap++) {
            for (int i = 0, j = gap; j < numberOfCoins; i++, j++) {
                // For each pair of coins [i...j], calculate maximum value Wong can get
                int x = (i + 2 <= j) ? dp[i + 2][j] : 0; // If Wong picks coin i, Strange picks coin (i+1), Wong gets dp[i+2][j]
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0; // If Wong picks coin i, Strange picks coin j, Wong gets dp[i+1][j-1]
                int z = (i <= j - 2) ? dp[i][j - 2] : 0; // If Wong picks coin j, Strange picks coin i, Wong gets dp[i][j-2]
                
                // Wong's turn: Choose the maximum of two scenarios: pick coin i or pick coin j
                dp[i][j] = Math.max(coins[i] + Math.min(x, y), coins[j] + Math.min(y, z));
            }
        }
        
        // The result for the full range [0...numberOfCoins-1] is stored in dp[0][numberOfCoins-1]
        return dp[0][numberOfCoins - 1];
    }

    public static void main(String[] args) {
        int coins[]= {6,8,9,2,1};
        int n=maxCoins(coins, coins.length);
        System.out.println("Maximum number of Coins Accpeted :"+n);
      
    }
}
