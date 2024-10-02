package com.nt.advanceddsa;

public class Ad_07_TreInsertAndSearch {

	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};

	static void insert(TrieNode root, String key) {
		TrieNode curr = root;
		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - 'a';
			if (curr.children[idx] == null) {
				curr.children[idx] = new TrieNode();
			}
			curr = curr.children[idx];
		}
		curr.isEndOfWord = true;
	}

	static boolean search(TrieNode root, String key) {

		TrieNode curr = root;
		for (int i = 0; i < key.length(); i++) {
			int idx = key.charAt(i) - 'a';
			if (curr.children[idx] == null) {
				return false;
			}
			curr = curr.children[idx];
		}
		return curr.isEndOfWord == true;
	}

	public static void main(String[] args) {
		

	}

}
