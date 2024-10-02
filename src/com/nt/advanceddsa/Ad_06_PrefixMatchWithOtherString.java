package com.nt.advanceddsa;

public class Ad_06_PrefixMatchWithOtherString {

	// T(c)=O(n*l) and S(C)=O(n*l)
	public static int klengthpref(String[] arr, int n, int k, String str) {
		int count = 0;
		if (k > str.length())
			return 0;
		else {
			for (String data : arr) {
				if (data.length() >= k && data.substring(0, k).equals(str.substring(0, k)))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String arr[] = { "abba", "abbb", "abbc", "abbd", "abaa", "abca" };
		String str = "abbg";
		int k = 3;
		int n = arr.length;
		int response = klengthpref(arr, n, k, str);
		System.out.println("The number of prefix is::"+response);

	}

}
