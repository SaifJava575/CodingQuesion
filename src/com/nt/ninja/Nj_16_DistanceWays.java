package com.nt.ninja;

public class Nj_16_DistanceWays {
    public static int distance(int n) {
        // Base case for small distances
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        
        // Create a dp array to store the number of ways for each distance
        int[] dp = new int[n + 1];
        
        // Initialize the base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // Fill the dp array using the recurrence relation
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        // Return the number of ways to reach distance n
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("The number of ways to cover distance :"+distance(4));
    }
}
