package com.nt.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class St_55_CircleOfString {

	// T(C)= O(N) and S(C)= O(N)
	public static int isCircle(int n, String arr[]) {
		int[] cnt = new int[26];
		Map<Character, List<Character>> map = new HashMap<>();
		for (String s : arr) {
			if (!map.containsKey(s.charAt(0)))
				map.put(s.charAt(0), new ArrayList<>());
			map.get(s.charAt(0)).add(s.charAt(s.length() - 1));
			cnt[s.charAt(0) - 'a']++;
			cnt[s.charAt(s.length() - 1) - 'a']++;
		}
		for (int i = 0; i < 26; i++)
			if (cnt[i] % 2 == 1)
				return 0;
		Set<Character> vis = new HashSet<>();
		return dfs(map, vis, arr[0].charAt(0)) ? 1 : 0;
	}

	static boolean dfs(Map<Character, List<Character>> map, Set<Character> vis, char c) {
		if (vis.contains(c))
			return vis.size() == map.size();
		vis.add(c);
		for (char ch : map.get(c))
			if (dfs(map, vis, ch))
				return true;
		return false;
	}

	public static void main(String[] args) {

		String arr[] = { "for", "geek", "rig", "kaf" };
		int n = arr.length;
		int res = isCircle(n, arr);
		System.out.println("Check the string circle posibility::" + res);
	}

}
