package com.nt.advanceddsa;

import java.util.LinkedList;

public class Ad_16_TrieDelete {
	class TrieNode {
		char content;
		boolean isEnd;
		int count;
		LinkedList<TrieNode> childList;

		public TrieNode(char c) {
			childList = new LinkedList<TrieNode>();
			isEnd = false;
			content = c;
			count = 0;
		}

		public TrieNode subNode(char c) {
			if (childList != null)
				for (TrieNode eachChild : childList)
					if (eachChild.content == c)
						return eachChild;
			return null;
		}
	}

	public static void deleteKey(TrieNode temp, char[] key) {
		for (char c : key)
			if (temp.subNode(c) != null)
				temp = temp.subNode(c);
		if (temp.isEnd)
			temp.isEnd = false;

	}

	public static void main(String[] args) {

	}

}
