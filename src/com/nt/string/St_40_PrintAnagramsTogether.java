package com.nt.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class St_40_PrintAnagramsTogether {

	public static List<List<String>> anagrams(String[] string_list) {
		List<List<String>> ans = new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : string_list) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			List<String> temp = map.get(String.copyValueOf(ch));
			if (temp != null)
				temp.add(s);
			else
				temp = new ArrayList<>(List.of(s));
			map.put(String.copyValueOf(ch), temp);
		}

		for (List<String> ss : map.values()) {
			ans.add(ss);
		}

		return ans;
	}

	public static void main(String[] args) {
		String words[] = { "act", "god", "cat", "dog", "tac" };
		List<List<String>> res = anagrams(words);
		for (List<String> list : res) {
			for (String ans : list)
				System.out.print(ans+" ");

		}
	}

}
