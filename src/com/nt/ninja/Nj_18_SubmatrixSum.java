package com.nt.ninja;
import java.util.ArrayList;
import java.util.List;

public class Nj_18_SubmatrixSum {

    public static ArrayList<Integer> findSubmatrixSum(ArrayList<ArrayList<Integer>> arr, ArrayList<ArrayList<Integer>> queries) {
        int N = arr.size();
        int M = arr.get(0).size();

        // Initialize the prefix sum array
        int[][] prefixSum = new int[N + 1][M + 1];

        // Build the prefix sum array
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = arr.get(i - 1).get(j - 1) 
                                 + prefixSum[i - 1][j] 
                                 + prefixSum[i][j - 1] 
                                 - prefixSum[i - 1][j - 1];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        // Process each query
        for (ArrayList<Integer> query : queries) {
            int r1 = query.get(0) + 1;
            int c1 = query.get(1) + 1;
            int r2 = query.get(2) + 1;
            int c2 = query.get(3) + 1;

            // Compute the sum for the submatrix
            int submatrixSum = prefixSum[r2][c2] 
                             - prefixSum[r1 - 1][c2] 
                             - prefixSum[r2][c1 - 1] 
                             + prefixSum[r1 - 1][c1 - 1];
            
            result.add(submatrixSum);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(4, 2)));
        arr.add(new ArrayList<>(List.of(1, 3)));

        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(List.of(0, 0, 1, 0))); // Submatrix sum query

        ArrayList<Integer> result = findSubmatrixSum(arr, queries);
        System.out.println(result); // Output should be [5]
    }
}
