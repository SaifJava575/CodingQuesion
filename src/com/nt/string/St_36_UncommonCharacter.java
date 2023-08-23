package com.nt.string;

import java.util.ArrayList;
import java.util.TreeSet;

public class St_36_UncommonCharacter {

	// T(c)=O(M+N) where M and N are the sizes of A and B respectively and
	// S(c)=O(M+N)

	public static String UncommonChars(String a, String b) {
		TreeSet<Character> ans = new TreeSet<>();
		for (int i = 0; i < a.length(); i++) {
			if (!b.contains(String.valueOf(a.charAt(i))))
				ans.add(a.charAt(i));
		}
		for (int i = 0; i < b.length(); i++) {
			if (!a.contains(String.valueOf(b.charAt(i))))
				ans.add(b.charAt(i));
		}
		ArrayList<Character> res = new ArrayList<>(ans);
		if (res.size() == 0)
			return "-1";
		String s = "";
		for (int i = 0; i < res.size(); i++) {
			s += res.get(i);
		}
		return s;

	}

	public static void main(String[] args) {
		String s1 = "saifuddin", s2 = "sujan";
		String res = UncommonChars(s1, s2);
		System.out.println("Uncommon String are :" + res);
	}

}
