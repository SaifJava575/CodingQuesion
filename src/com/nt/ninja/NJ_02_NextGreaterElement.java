package com.nt.ninja;
import java.util.*;

public class NJ_02_NextGreaterElement {

    public static int[] nextGreaterElement(int n, int[] A, int m, int[] B) {
        // Map to store the next greater element for each element in B
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // Stack to find the next greater element
        Stack<Integer> stack = new Stack<>();

        // Traverse array B from right to left to build the next greater element map
        for (int i = m - 1; i >= 0; i--) {
            int currentElement = B[i];
            
            // Pop elements from the stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= currentElement) {
                stack.pop();
            }
            
            // If stack is not empty, the top of the stack is the next greater element
            nextGreaterMap.put(currentElement, stack.isEmpty() ? -1 : stack.peek());

            // Push the current element onto the stack
            stack.push(currentElement);
        }

        // Result array to store the answer for each element in A
        int[] result = new int[n];

        // For each element in A, get the next greater element from the map
        for (int i = 0; i < n; i++) {
            result[i] = nextGreaterMap.get(A[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Input
        int N = 6;
        int[] A = {1, 2, 0, 3, 4, 5};
        int M = 7;
        int[] B = {3, 5, 0, 2, 1, 6, 4};

        // Get the result
        int[] result = nextGreaterElement(N, A, M, B);

        // Print the result
        System.out.println(Arrays.toString(result));  // Output: [6, 6, 2, 5, -1, 6]
    }
}
