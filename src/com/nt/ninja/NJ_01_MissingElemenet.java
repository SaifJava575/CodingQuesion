package com.nt.ninja;

public class NJ_01_MissingElemenet {
	
	public static int missingNumber(int[] arr, int n) {

		int commonDifference = (arr[n - 1] - arr[0]) / n;

        int left = 0, right = n - 1;
        
        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the missing number is on the left or right half
            if ((arr[mid] - arr[0]) / commonDifference == mid) {
                // If the current element is in the correct place, the missing number is on the right
                left = mid + 1;
            } else {
                // If the current element is not in the correct place, the missing number is on the left
                right = mid - 1;
            }
        }

        // The missing number is located at index 'left'
        return arr[0] + left * commonDifference;
	}

	public static void main(String[] args) {
		int arr[]= {5, 10, 20, 25};
		int n=missingNumber(arr, arr.length);
		System.out.println(n);
	}
}