package com.nt.ninja;
public class NJ_13_HouseLoot {

    // Function to calculate the maximum money looted
    public static int maxMoneyLooted(int[] houses) {
        int n = houses.length;
        
        // If there are no houses, the maximum loot is 0
        if (n == 0) return 0;
        
        // If there is only one house, loot that house
        if (n == 1) return houses[0];
        
        // dp[i] represents the maximum money that can be looted from the first i houses
        int[] dp = new int[n];
        
        // Base cases
        dp[0] = houses[0];           // If only one house, loot it
        dp[1] = Math.max(houses[0], houses[1]);  // Loot the house with more money among the first two houses
        
        // Fill the dp array for the remaining houses
        for (int i = 2; i < n; i++) {
            // Either loot the current house and add the money from dp[i-2] (non-consecutive), or skip the current house
            dp[i] = Math.max(dp[i - 1], houses[i] + dp[i - 2]);
        }
        
        // The answer will be the maximum money looted from all the houses
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] houses1 = {10, 2, 3, 11};
        System.out.println(maxMoneyLooted(houses1));  // Output: 21
        
        // Sample Input 2
        int[] houses2 = {5, 5, 10, 100, 10, 5};
        System.out.println(maxMoneyLooted(houses2));  // Output: 110
    }
}
