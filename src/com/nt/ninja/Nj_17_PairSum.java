package com.nt.ninja;
import java.util.*;

public class Nj_17_PairSum {
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();  // To store the result pairs
        HashMap<Integer, Integer> map = new HashMap<>();  // To store frequency of elements

        // Traverse through the array
        for (int num : arr) {
            int complement = s - num;  // Calculate the complement
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                int count = map.get(complement);
                while (count-- > 0) {
                    int[] pair = new int[]{Math.min(num, complement), Math.max(num, complement)};
                    result.add(pair);
                }
            }
            // Add the current number to the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort the result pairs as per the problem requirements
        result.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements and the target sum
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];

        // Input array elements
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Get the result pairs
        List<int[]> pairs = pairSum(arr, S);

        // Output the result
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        sc.close();
    }
}
