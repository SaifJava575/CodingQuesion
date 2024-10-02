package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ad_01_WordBoggle {

	//T(C)=O(N*W + R*C^2)  and S(C)=O(N*W + R*C)
	public static String[] wordBoggle(char board[][], String[] dictionary) {
		ArrayList<String> ans = new ArrayList<>();
		for (String str : dictionary) {
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++)
					if (board[i][j] == str.charAt(0) && dfs(i, j, board, str, 0))
						ans.add(str);
		}

		Set<String> uniqueSet = new LinkedHashSet<>(ans);
		String[] res = uniqueSet.toArray(new String[0]);
		return res;
	}

	public static boolean dfs(int i, int j, char[][] board, String str, int count) {
		if (count == str.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != str.charAt(count)) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = '*';
		boolean result = dfs(i + 1, j, board, str, count + 1) || dfs(i - 1, j, board, str, count + 1)
				|| dfs(i, j + 1, board, str, count + 1) || dfs(i, j - 1, board, str, count + 1)
				|| dfs(i + 1, j + 1, board, str, count + 1) || dfs(i + 1, j - 1, board, str, count + 1)
				|| dfs(i - 1, j - 1, board, str, count + 1) || dfs(i - 1, j + 1, board, str, count + 1);
		board[i][j] = temp;
		return result;
	}

	public static void main(String[] args) {
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GO" };
		char[][] board = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		String response[] = wordBoggle(board, dictionary);
		System.out.println("Find the output is ::" + response);
	}

}
