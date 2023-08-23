package com.nt.string;

public class St_08_LongestCommonPrefix {

	// T(C)=O(N*max(|arri|)) S(C)=O(max(|arri|)) for result

	public static String longestCommonprefix(String arr[], int n) {
		int i = 0;
		String res = arr[0];
		
		// base condition
		if (arr.length == 1)
			return "-1";
	
		while (i < n) {
			int k = res.length() > arr[i].length() ? arr[i].length() : res.length();
			int j = 0;
			while (j < k) {
				if (res.charAt(j) == arr[i].charAt(j))
					j++;
				else
					break;

			}
			res = res.substring(0, j);
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		String arr[]= {"geeksforgeeks", "geeks", "geek", "geezer"};	
		String res = longestCommonprefix(arr, arr.length);
		System.out.println("Longest Common prefix is ::" + res);
	}

}
