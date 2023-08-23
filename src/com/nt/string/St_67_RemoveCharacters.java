package com.nt.string;

import java.util.LinkedHashSet;
import java.util.Set;

public class St_67_RemoveCharacters {

	// T(C)=O( |String1| + |String2| ) and S(c)=O(K),Where K = Constant
	public static String removeChar(String s1, String s2) {
		String ans = "";
		Set<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < s2.length(); i++) {
			set.add(s2.charAt(i));
		}
		for (int i = 0; i < s1.length(); i++) {
			if (!set.contains(s1.charAt(i)))
				ans += s1.charAt(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		String s1 = "occurrence", s2 = "car";
		String res = removeChar(s1, s2);
		System.out.println(res);
	}

}
