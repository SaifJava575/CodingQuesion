package com.nt.ninja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NJ_19_MaximumSubarraySum {

    public static int maximumSubarraySum(int n, ArrayList<Integer> v) {
        // Step 1: Sort the array in descending order
        Collections.sort(v, Collections.reverseOrder());
        
        // Step 2: Compute the maximum subarray sum using Kadane's Algorithm
        int maxSum = 0;
        int currentSum = 0;
        
        for (int num : v) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        // Sample test cases
        ArrayList<Integer> test1 = new ArrayList<>(List.of(1, -5, 1, 1, -4));
        ArrayList<Integer> test2 = new ArrayList<>(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        
        System.out.println(maximumSubarraySum(5, test1)); // Output: 3
        System.out.println(maximumSubarraySum(9, test2)); // Output: 6 (subarray [4, -1, 2, 1])
    }
}
