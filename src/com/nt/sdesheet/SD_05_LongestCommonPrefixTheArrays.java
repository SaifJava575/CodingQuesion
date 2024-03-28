package com.nt.sdesheet;

public class SD_05_LongestCommonPrefixTheArrays {

	// T(C)=O(N*min(|arri|)). and S(C)=O(min(|arri|)
	static String longestCommonPrefix(String arr[], int n) {
		String dummy = arr[0];
		for (int i = 0; i < n; i++) {
			while (arr[i].indexOf(dummy) != 0)
				dummy = dummy.substring(0, dummy.length() - 1);
			if (dummy.isEmpty())
				return "-1";
		}
		return dummy;
	}

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		String response = longestCommonPrefix(arr, arr.length);
		System.out.println("The longest Common Prefix is ::" + response);
	}

}
