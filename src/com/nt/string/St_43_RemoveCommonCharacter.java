package com.nt.string;

import java.util.LinkedHashMap;

public class St_43_RemoveCommonCharacter {

	public static String concatenatedString(String s1, String s2) {
		String a = "";
		for (int i = 0; i < s1.length(); i++) {
			if (!s2.contains(s1.charAt(i) + "")) {
				a = a + s1.charAt(i);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (!s1.contains(s2.charAt(i) + "")) {
				a = a + s2.charAt(i);
			}
		}

		if (a.isEmpty()) {
			return "-1";
		}
		return a;
	}

	public static String concatenatedString1(String s1, String s2) {
		LinkedHashMap<Character, Integer> hs = new LinkedHashMap<>();
		int n1 = s1.length();
		int n2 = s2.length();
		for (int i = 0; i < n2; i++) {
			hs.put(s2.charAt(i), 1);
		}
		String res = "";
		for (int i = 0; i < n1; i++) {
			if (!hs.containsKey(s1.charAt(i)))
				res = res + s1.charAt(i);
			else
				hs.put(s1.charAt(i), 2);
		}
		for (int i = 0; i < n2; i++) {
			if (hs.get(s2.charAt(i)) == 1)
				res = res + s2.charAt(i);
		}
		if (res.length() == 0)
			return "-1";
		else
			return res;
	}

	public static void main(String[] args) {
		String str="Saifuddin",str1="Sujan";
		String actualResult=concatenatedString1(str, str1);
		System.out.println("The uncommon Character is::"+actualResult);
	}

}
