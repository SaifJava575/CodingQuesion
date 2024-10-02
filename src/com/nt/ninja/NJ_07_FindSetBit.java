package com.nt.ninja;

public class NJ_07_FindSetBit {
    public static int findSetBit(int n) {
        // Step 1: Check if n has exactly one set bit
        if (n == 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        // Step 2: Find the position of the only set bit
        int position = 1; // Position starts from 1 (LSB)
        while (n > 1) {
            n >>= 1; // Right shift n
            position++;
        }

        return position;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findSetBit(4));  // Output: 3
        System.out.println(findSetBit(8));  // Output: 4
        System.out.println(findSetBit(9));  // Output: -1
        System.out.println(findSetBit(0));  // Output: -1
    }
}
