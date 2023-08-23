package com.nt.dp;

import java.util.ArrayList;

public class Dp_05_LongestIncreasingSubSequence {

	public static int longestSubsequence(int size, int arr[]) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(arr[0]);
		int len = 1; // 1 ele in res
		for (int i = 1; i < size; i++) {
			if (arr[i] > res.get(res.size() - 1)) {
				res.add(arr[i]);
				len++;
			} else { // we overwrite the subsequence by putting the val in the ele which is just >=
				int index = binarySearch(res, arr[i]);
				res.set(index, arr[i]);
			}
		}
		return len;
	}

	public static int binarySearch(ArrayList<Integer> res, int key) {
		int low = 0, high = res.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key == res.get(mid))
				return mid;
			else if (key > res.get(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}

		return low;
	}

	public static void main(String[] args) {
		int A[]={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		int size=A.length;
		int response=longestSubsequence(size, A);
		System.out.println("The longest Increasing Subsequence is::"+response);
			    

	}

}
