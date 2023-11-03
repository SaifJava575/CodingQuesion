package com.nt.advanceddsa;

import java.util.HashMap;
import java.util.Map;

public class Ad_02_MostFrequencedWord {

	//T(C)=O(n)  and S(C)=O(n)
	public static String mostFrequentWord(String arr[], int n) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		int max = Integer.MIN_VALUE;
		String res = "";
		for (int i = 0; i < n; i++) {
			if (map.get(arr[i]) >= max) {
				max = map.get(arr[i]);
				map.put(arr[i], 0);
				res = arr[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		//String arr[] = { "geeks", "for", "geeks" };
		String arr[] = { "hello", "for", "wolrd" };
		int n = arr.length;
		String response = mostFrequentWord(arr, n);
		System.out.println("Most Frequency Word is ::" + response);
	}

}
