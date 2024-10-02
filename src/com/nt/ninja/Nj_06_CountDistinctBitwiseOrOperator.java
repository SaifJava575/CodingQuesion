package com.nt.ninja;
import java.util.HashSet;
import java.util.Set;

public class Nj_06_CountDistinctBitwiseOrOperator {

    public static int countDistinctBitwiseOR(int[] arr, int n) {
        // Set to store all distinct OR values
        Set<Integer> distinctOrValues = new HashSet<>();
        // Set to store OR values of subarrays ending at the current element
        Set<Integer> previous = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // Set to store OR values of subarrays ending at current element arr[i]
            Set<Integer> current = new HashSet<>();
            // Add current element itself as it forms a subarray [arr[i]]
            current.add(arr[i]);

            // Combine current element with all OR values of subarrays ending at previous elements
            for (int val : previous) {
                current.add(val | arr[i]);
            }

            // Add all current OR results to the distinct set
            distinctOrValues.addAll(current);
            // Move current set to previous for the next iteration
            previous = current;
        }

        // Return the size of the set which gives the number of distinct OR values
        return distinctOrValues.size();
    }

    public static void main(String[] args) {
        // Example 1:
        int[] arr1 = {1, 2, 3};
        int result1 = countDistinctBitwiseOR(arr1, arr1.length);
        System.out.println(result1); // Output: 3

        // Example 2:
        int[] arr2 = {1, 5};
        int result2 = countDistinctBitwiseOR(arr2, arr2.length);
        System.out.println(result2); // Output: 2
    }
}
