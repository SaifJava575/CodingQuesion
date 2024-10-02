package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.Collections;

public class Ad_04_PatternMatchingCamelCase {

	//T(C)=O(N*|S|) and S(C)= O(26*N)
	public static ArrayList<String> CamelCase(int N, String[] Dictionary, String Pattern) {
		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < Dictionary.length; i++) {
			if (isValid(Dictionary[i], Pattern))
				ans.add(Dictionary[i]);
		}
		if (ans.size() == 0)
			ans.add("-1");
		Collections.sort(ans);
		return ans;
	}

	private static boolean isValid(String word, String pattern) {
		int j = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				if (word.charAt(i) != pattern.charAt(j))
					return false;
				j = j + 1;
				if (j >= pattern.length())
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String Dictionary[] = { "WelcomeGeek", "WelcomeToGeeksForGeeks", "GeeksForGeeks" };
		String Pattern = "WTG";
		int N = Dictionary.length;
		ArrayList<String> response = CamelCase(N, Dictionary, Pattern);
		System.out.println(response);

	}

}
