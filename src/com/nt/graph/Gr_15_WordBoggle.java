package com.nt.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Gr_15_WordBoggle {

	// T(c)=O(N*W + R*C^2) and S(c)= O(N*W + R*C)
	public static String[] wordBoggle(char board[][], String[] dictionary) {

		int row = board.length;
		int col = board[0].length;
		Map<Character, Integer> map = new HashMap<>();
		String res[] = new String[dictionary.length];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map.containsKey(board[i][j]))
					map.put(board[i][j], map.get(board[i][j]) + 1);
				else
					map.put(board[i][j], 1);
			}
		}
		String word = "";
		int m = 0;
		for (int i = 0; i < dictionary.length; i++) {
			word = dictionary[i];
			char wordChar[] = word.toCharArray();

			String ele = "";
			for (int j = 0; j < wordChar.length; j++) {
				if (map.containsKey(wordChar[j]))
					ele += wordChar[j];
				else
					continue;
			}

			if (wordChar.length == ele.length()) {
				res[m++] = ele;
				ele = "";
			}
			ele = "";
		}
		return res;
	}

	public static String[] wordBoggle1(char board[][], String[] dictionary) {
		// Write your code here
		int n = board.length;
		int m = board[0].length;
		Set<String> set = new HashSet<>();

		for (String str : dictionary) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (wordExist(board, str, i, j, n, m, 0))
						set.add(str);
				}
			}
		}

		ArrayList<String> ans = new ArrayList<>(set);
		Collections.sort(ans);
		String finalAns[] = new String[set.size()];
		int idx = 0;
		for (String str : ans) {
			finalAns[idx] = str;
			idx++;
		}

		return finalAns;
	}

	public static boolean wordExist(char board[][], String s, int i, int j, int n, int m, int idx) {

		if (i < 0 || i >= n || j < 0 || j >= m) {
			return false;
		}

		if (s.charAt(idx) != board[i][j]) {
			return false;
		}

		if (idx == s.length() - 1) {
			return true;
		}

		char temp = board[i][j];
		board[i][j] = '*';

		boolean a = wordExist(board, s, i, j + 1, n, m, idx + 1);
		boolean b = wordExist(board, s, i, j - 1, n, m, idx + 1);
		boolean c = wordExist(board, s, i + 1, j, n, m, idx + 1);
		boolean d = wordExist(board, s, i - 1, j, n, m, idx + 1);
		boolean e = wordExist(board, s, i + 1, j + 1, n, m, idx + 1);
		boolean f = wordExist(board, s, i - 1, j + 1, n, m, idx + 1);
		boolean g = wordExist(board, s, i + 1, j - 1, n, m, idx + 1);
		boolean h = wordExist(board, s, i - 1, j - 1, n, m, idx + 1);

		board[i][j] = temp;
		return a || b || c || e || f || g || h || d;
	}

	public static void main(String[] args) {
		char board[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GO" };
		String response[] = wordBoggle1(board, dictionary);
		for (String val : response)
			System.out.println(val);
	}

}
