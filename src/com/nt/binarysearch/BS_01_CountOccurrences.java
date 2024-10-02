package com.nt.binarysearch;
public class BS_01_CountOccurrences {

    public static int countOccurrences(int[] arr, int x) {
        // Find the first occurrence of x
        int first = findFirstOccurrence(arr, x);
        // If x is not present, return 0
        if (first == -1) {
            return 0;
        }
        // Find the last occurrence of x
        int last = findLastOccurrence(arr, x);
        // The count is the difference between the last and first indices plus one
        return last - first + 1;
    }

    private static int findFirstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid; // Found x, continue to search in the left half
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    private static int findLastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid; // Found x, continue to search in the right half
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample input
        int[][] testCases = {
            {1, 1, 2, 2, 2, 2, 3},
            {1, 2, 2, 3, 3},
            {2, 3, 4, 4},
            {5, 7, 7, 8, 8, 10}
        };
        
        int[] targets = {2, 4, 4, 10};

        for (int i = 0; i < testCases.length; i++) {
            int count = countOccurrences(testCases[i], targets[i]);
            System.out.println(count);
        }
    }
}
