package com.nt.ninja;

public class Nj_08_NumberOfMismatchBit {
    public static int numberOfMismatchingBits(int first, int second) {
        // Step 1: XOR the two numbers to find differing bits
        int xorResult = first ^ second;

        // Step 2: Count the number of set bits (1s) in the XOR result
        int count = 0;
        while (xorResult > 0) {
            count += xorResult & 1; // Check the least significant bit
            xorResult >>= 1;        // Right shift to check the next bit
        }

        return count;
    }

    public static void main(String[] args) {
        // Example case
        int first = 11;  // Binary: 1011
        int second = 15; // Binary: 1111
        System.out.println(numberOfMismatchingBits(first, second)); // Output: 1
    }
}
