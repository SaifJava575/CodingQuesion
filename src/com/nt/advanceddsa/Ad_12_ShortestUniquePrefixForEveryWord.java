package com.nt.advanceddsa;

import java.util.ArrayList;

class Node {
	Node[] children;
	boolean isTerminal;
	int cnt;

	Node() {
		this.children = new Node[26];
		this.isTerminal = false;
		this.cnt = 0;
	}

	public void make_cnt() {
		this.cnt++;
	}

	public int give_cnt() {
		return this.cnt;
	}

	public boolean isContainsKey(int indx) {
		return (this.children[indx] != null);
	}

	public Node getKey(int indx) {
		return this.children[indx];
	}

	public void setKey(int indx, Node nd) {
		this.children[indx] = nd;
	}

	public void setEnd() {
		this.isTerminal = true;
	}

	public boolean isEnd() {
		return this.isTerminal;
	}
}

class Trie {
	Node root;

	Trie() {
		this.root = new Node();
	}

	public void insert(String str) {
		Node tmp = root;
		for (int i = 0; i < str.length(); i++) {
			int indx = str.charAt(i) - 'a';
			// System.out.println(tmp.children[indx]);
			if (!tmp.isContainsKey(indx)) {
				tmp.setKey(indx, new Node());
			}
			tmp = tmp.getKey(indx);
			tmp.make_cnt();
		}
		tmp.setEnd();
	}

	public String search(String str) {
		Node tmp = root;
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			int indx = str.charAt(i) - 'a';
			if (tmp.give_cnt() == 1) {
				break;
			}
			ans += str.charAt(i);
			tmp = tmp.getKey(indx);
		}
		return ans;
	}
}

public class Ad_12_ShortestUniquePrefixForEveryWord {

	// T(C)= O(N*length of each word) and S(C)=O(N*length of each word)
	static String[] findPrefixes(String[] arr, int N) {
		Trie trie = new Trie();
		for (String str : arr) {
			trie.insert(str);
		}
		ArrayList<String> ans = new ArrayList<>();
		for (String str : arr) {
			String tmp = trie.search(str);
			ans.add(tmp);
		}
		return ans.toArray(new String[ans.size()]);
	}

	public static void main(String[] args) {

		String arr[] = { "zebra", "dog", "duck", "dove" };
		int length = arr.length;
		String res[] = findPrefixes(arr, length);
		for (String val : res)
			System.out.println(val + " ");
	}

}
