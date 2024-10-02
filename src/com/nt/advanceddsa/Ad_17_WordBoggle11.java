package com.nt.advanceddsa;

import java.util.HashSet;
import java.util.Set;

public class Ad_17_WordBoggle11 {

	//T(C)=O(4^(N^2))  and S(C)=O(N^2)
	public static String[] wordBoggle(char board[][], String[] dictionary) {
		Set<String> result = new HashSet<>();
		for (String word : dictionary) {
			if (exist(board, word)) {
				result.add(word);
			}
		}

		return result.toArray(new String[0]);
	}

	private static boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean dfs(char[][] board, int i, int j, String word, int index) {
		if (index == word.length()) {
			return true; // Word found
		}
		int rows = board.length;
		int cols = board[0].length;
		// Check if current position is out of bounds or if the character does not match
		if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index)) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = '#'; // Mark the cell as visited

		// Explore in all 8 possible directions
		boolean found = dfs(board, i + 1, j, word, index + 1) || dfs(board, i - 1, j, word, index + 1)
				|| dfs(board, i, j + 1, word, index + 1) || dfs(board, i, j - 1, word, index + 1)
				|| dfs(board, i + 1, j + 1, word, index + 1) || dfs(board, i - 1, j - 1, word, index + 1)
				|| dfs(board, i + 1, j - 1, word, index + 1) || dfs(board, i - 1, j + 1, word, index + 1);

		board[i][j] = temp; // Backtrack

		return found;
	}

	public static void main(String[] args) {
		char board[][] = { { 'C', 'A', 'P' }, { 'A', 'N', 'D' }, { 'T', 'I', 'E' } };
		String dictionary[] = { "CAT" };
		String response[] = wordBoggle(board, dictionary);
		for (String str : response)
			System.out.println(str);

	}

}
