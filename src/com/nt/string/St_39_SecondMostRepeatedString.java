package com.nt.string;

import java.util.HashMap;
import java.util.Map;

public class St_39_SecondMostRepeatedString {

	// T(C)=O(N*max(|Si|). AND S(c)=O(N*max(|Si|).
	public static String secFrequent(String arr[], int N) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			h.put(arr[i], h.getOrDefault(arr[i], 0) + 1);
		}
		int max = 0;
		String str = "";
		int secmax = 0;
		for (Map.Entry<String, Integer> e : h.entrySet()) {
			if (e.getValue() > max)
				max = e.getValue();
		}
		for (Map.Entry<String, Integer> e : h.entrySet()) {
			if (e.getValue() > secmax && e.getValue() != max) {
				secmax = e.getValue();
				str = e.getKey();
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String arr[] = { "geek", "for", "geek", "for", "geek", "aaa" };
		int n = arr.length;
		String res = secFrequent(arr, n);
		System.out.println("Second Frequency String is::" + res);
	}

}
