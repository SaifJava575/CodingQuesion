package com.nt.ninja;
public class NJ_12_CoinChange {

    // Function to count the total number of ways to make change
    public static long countWaysToMakeChange(int denominations[], int value) {
        // Create a dp array to store the number of ways to make change for each value from 0 to 'value'
        long[] dp = new long[value + 1];
        
        // Base case: there's 1 way to make change for value 0 (by choosing no coins)
        dp[0] = 1;
        
        // Iterate over each denomination
        for (int coin : denominations) {
            // Update the dp array for all values >= coin
            for (int v = coin; v <= value; v++) {
                dp[v] += dp[v - coin];
            }
        }
        
        // Return the number of ways to make change for the given value
        return dp[value];
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] denominations1 = {1, 2, 3};
        int value1 = 4;
        System.out.println(countWaysToMakeChange(denominations1, value1));  // Output: 4

        // Sample Input 2
        int[] denominations2 = {5, 3, 2};
        int value2 = 1;
        System.out.println(countWaysToMakeChange(denominations2, value2));  // Output: 0
    }
}
