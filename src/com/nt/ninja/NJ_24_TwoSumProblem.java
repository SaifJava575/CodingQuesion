package com.nt.ninja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class NJ_24_TwoSumProblem {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            // Read the size of the array and the target
            int N = scanner.nextInt();
            int TARGET = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();

            // Read the array elements
            for (int i = 0; i < N; i++) {
                arr.add(scanner.nextInt());
            }*/
    	
    	ArrayList<Integer> arr=new ArrayList<>();
    	Collections.addAll(arr, 2,7,11,13);
    	int target=9;
    	int n=arr.size();

            // Find pairs
            ArrayList<Pair<Integer, Integer>> result = twoSum(arr, target, n);

            // Print the results
            for (Pair<Integer, Integer> pair : result) {
                System.out.println(pair.key + " " + pair.value);
            }
        }


    public static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - arr.get(i);

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Add all pairs found
                for (int j = 0; j < map.get(complement); j++) {
                    result.add(new Pair<>(complement, arr.get(i)));
                }
            }

            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        return result;
    }
}
