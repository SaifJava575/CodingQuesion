package com.nt.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class St_19_LongestDistinctSubStringLength {

	// T(C)=O(|S|) and S(C)= O(K), where K is Constant.
	public static int longestSubstrDistinctChars(String S) {
		int l = 0, r = 0;
		int maxlength = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (r < S.length()) {
			if (map.containsKey(S.charAt(r))) {
				map.remove(S.charAt(l));
				l++;
			} else {
				map.put(S.charAt(r), 1);
				r++;
				maxlength = Math.max(maxlength, (r - l));
			}
		}

		return maxlength;
	}

	public static int longestSubstrDistinctChars1(String S) {
		int maxLong = 0;
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < S.length(); i++) {
			while (queue.contains(S.charAt(i))) {
				queue.poll();
				if (queue.isEmpty())
					break;
			}
			queue.offer(S.charAt(i));
			maxLong = Math.max(maxLong, queue.size());
		}

		return maxLong;

	}

	public static void main(String[] args) {

		String str = "saifuddin";
		int res = longestSubstrDistinctChars1(str);
		System.out.println("Longest Substring length is ::" + res);

	}

}
