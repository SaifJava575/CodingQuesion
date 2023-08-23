package com.nt.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class St_44_CaseSpecificSortingOfString {

	// T(C)=O(Nlog(N)). and S(C)= O(N)
	public static String caseSort(String str) {
		StringBuilder ans = new StringBuilder();
		List<Character> lower = new ArrayList<>();
		List<Character> upper = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				lower.add(str.charAt(i));
			else
				upper.add(str.charAt(i));
		}
		Collections.sort(lower);
		Collections.sort(upper);
		int a = 0, b = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				ans.append(lower.get(a++));
			} else
				ans.append(upper.get(b++));
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		String S = "defRTSersUXI";
		String res = caseSort(S);
		System.out.println("Case specific sorting of the String is::" + res);
	}

}
