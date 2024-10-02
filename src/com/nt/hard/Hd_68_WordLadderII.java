package com.nt.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Hd_68_WordLadderII {

	// T(C)=O(N*(logN * M * 26)) and S(C)=O(N * M) where N = length of wordList and
	// M = |wordListi|
	public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
		Set<String> set = new HashSet<>();
		Map<String, Integer> dist = new HashMap<>();
		ArrayList<ArrayList<String>> res = new ArrayList<>();

		for (String word : wordList) {
			set.add(word);
		}

		Queue<String> q = new LinkedList<>();
		q.offer(startWord);
		dist.put(startWord, 0);

		while (!q.isEmpty()) {
			String cur = q.poll();
			if (cur.equals(targetWord))
				break;
			char[] charCur = cur.toCharArray();

			for (int i = 0; i < cur.length(); i++) {
				char c = charCur[i];
				for (char j = 'a'; j <= 'z'; j++) {
					charCur[i] = j;
					String s = new String(charCur);
					if (set.contains(s) && dist.get(s) == null) {
						dist.put(s, dist.get(cur) + 1);
						q.offer(s);
					}
				}
				charCur[i] = c;
			}
		}

		if (dist.get(targetWord) == null)
			return res;

		List<String> path = new ArrayList<>();
		path.add(targetWord);
		dfs(targetWord, startWord, dist, res, path);

		return res;
	}

	private static void dfs(String word, String startWord, Map<String, Integer> dist, ArrayList<ArrayList<String>> res,
			List<String> path) {
		if (word.equals(startWord)) {
			ArrayList<String> list = new ArrayList<>(path);
			Collections.reverse(list);
			res.add(list);
			return;
		}
		char[] charCur = word.toCharArray();

		for (int i = 0; i < word.length(); i++) {
			char c = charCur[i];
			for (char j = 'a'; j <= 'z'; j++) {
				charCur[i] = j;
				String s = new String(charCur);
				if (dist.get(s) != null && dist.get(s) + 1 == dist.get(word)) {
					path.add(s);
					dfs(s, startWord, dist, res, path);
					path.remove(path.size() - 1);
				}
			}
			charCur[i] = c;
		}
	}

	public static void main(String[] args) {
		String startWord = "der", targetWord = "dfs";
		String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
		ArrayList<ArrayList<String>> response = findSequences(startWord, targetWord, wordList);
		System.out.println("Minimium Possible Transform possible Source to Target destination ::"+ response.size());
		for (ArrayList<String> res : response) {
			for (String val : res)
				System.out.print(val + " ");
			System.out.println();
		}

	}

}
