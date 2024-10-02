package com.nt.ninja;
public class NJ_10_MaxSumTwoSubarrays {
    public static int maxSumTwoSubarray(int[] arr, int N, int K) {
        // Arrays to store max sum of subarrays of length K from left and right
        int[] leftMaxSum = new int[N];
        int[] rightMaxSum = new int[N];

        // Calculate prefix sums for subarrays of length K from the left
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        leftMaxSum[K - 1] = sum;
        for (int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[i - K];
            leftMaxSum[i] = Math.max(leftMaxSum[i - 1], sum);
        }

        // Calculate suffix sums for subarrays of length K from the right
        sum = 0;
        for (int i = N - 1; i >= N - K; i--) {
            sum += arr[i];
        }
        rightMaxSum[N - K] = sum;
        for (int i = N - K - 1; i >= 0; i--) {
            sum = sum + arr[i] - arr[i + K];
            rightMaxSum[i] = Math.max(rightMaxSum[i + 1], sum);
        }

        // Calculate the maximum sum of two non-overlapping subarrays
        int maxSum = Integer.MIN_VALUE;
        for (int i = K - 1; i < N - K; i++) {
            maxSum = Math.max(maxSum, leftMaxSum[i] + rightMaxSum[i + 1]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] arr1 = {7, 1, 6, 9, 2};
        int N1 = arr1.length;
        int K1 = 2;
        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxSumTwoSubarray(arr1, N1, K1));

        // Sample Input 2
        int[] arr2 = {10, 1, 3, 15, 30, 40, 4, 50, 2, 1};
        int N2 = arr2.length;
        int K2 = 3;
        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxSumTwoSubarray(arr2, N2, K2));

        int[] arr3 = {4, 8, -1, -23, 8, 7, -6, 5, 0};
        int N3 = arr3.length;
        int K3 = 2;
        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxSumTwoSubarray(arr3, N3, K3));
    }
}
