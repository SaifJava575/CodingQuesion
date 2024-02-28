package com.nt.hard;

import java.util.ArrayList;
import java.util.List;

public class Hd_59_WordBreakPart2 {

	static void PrintAll(List<String> l, String str, String ans, List<String> dict) {
		if (str.length() == 0) {
			l.add(ans.trim());
			return;
		}
		for (int i = 0; i <= str.length() - 1; i++) {
			String left = str.substring(0, i + 1);
			if (dict.contains(left)) {
				String right = str.substring(i + 1);
				PrintAll(l, right, ans + left + " ", dict);
			}
		}
	}

	static List<String> wordBreak(int n, List<String> dict, String s) {
		List<String> ans = new ArrayList<>();
		PrintAll(ans, s, "", dict);
		return ans;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		
		String dict[] = { "cats", "cat", "and", "sand", "dog" };
		int n=dict.length;
		List<String> list=new ArrayList<>();
		for(String val:dict)
			list.add(val);
		List<String> response=wordBreak(n, list, s);
		System.out.println(response);
	}

}
