package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ad_11_GeeksAndString {

	// T(C)=: O(Q*x) + O(N*L and S(C)=O(N*List [i])
	public static List<Integer> prefixCount(int N, int Q, String li[], String query[]) {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int m = li[i].length();
			for (int j = 1; j <= m; j++) {
				String s = li[i].substring(0, j);
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
		} // for
		for (String q : query)
			list.add(map.get(q) == null ? 0 : map.get(q));
		return list;
	}

	public static void main(String[] args) {
		String li[] = { "abracadabra", "geeksforgeeks", "abracadabra", "geeks", "geeksthrill" };
		String query[] = { "abr", "geeks", "geeksforgeeks", "ge", "gar" };
		int ln = li.length;
		int qn = query.length;
		List<Integer> response = prefixCount(ln, qn, li, query);
		System.out.println(response);
	}

}
