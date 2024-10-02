package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Hd_45_PhoneDirectory {

	// T(c)=O(|s| * n * max|contact[i]|) and S(C)= O(n * max|contact[i]|)
	static ArrayList<ArrayList<String>> displayContacts(int n, String contacts[], String s) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		for (int i = 1; i <= s.length(); i++) {
			String prefix = s.substring(0, i);
			HashSet<String> hs = new HashSet<>();
			for (int j = 0; j < n; j++) {
				int len = contacts[j].length();
				if (len < i)
					continue;
				else {
					String prefixContact = contacts[j].substring(0, i);
					if (prefix.equals(prefixContact)) {
						hs.add(contacts[j]);
					}
				}

			}
			ArrayList<String> temp;
			if (hs.size() == 0) {
				temp = new ArrayList<>();
				temp.add("0");
			} else {
				temp = new ArrayList<>(hs);
				Collections.sort(temp);
			}
			ans.add(temp);
		}
		return ans;
	}

	public static void main(String[] args) {
		String contact[] = { "geeikistest", "geeksforgeeks", "geeksfortest" };
		String s = "geeips";
		int n = contact.length;
		ArrayList<ArrayList<String>> response = displayContacts(n, contact, s);
		System.out.println("The Exppected Output is ::" + response);

	}

}
