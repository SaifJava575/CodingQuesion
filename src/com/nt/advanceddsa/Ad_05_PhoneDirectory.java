package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ad_05_PhoneDirectory {

	// T(c)=O(|s| * n * max|contact[i]|) and S(C)=O(n * max|contact[i]|)
	static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
		int i = 0;
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		while (i < s.length()) {
			ArrayList<String> arr = new ArrayList<>();
			String st = s.substring(0, i + 1);
			for (String str : contact) {
				if (i < str.length() && str.substring(0, i + 1).equals(st) && !arr.contains(str))
					arr.add(str);
			}
			i++;
			if (arr.isEmpty())
				arr.add("0");
			Collections.sort(arr, new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
			ans.add(arr);
		}
		return ans;
	}

	public static void main(String[] args) {
		String contact[] = { "geeikistest", "geeksforgeeks", "geeksfortest" };
		String s = "geeips";
		int n = contact.length;
		ArrayList<ArrayList<String>> response = displayContacts(n, contact, s);
		System.out.println(response);
	}

}
