package com.nt.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Hd_17_AllienDictionary {

	//T(C)= O(N * |S| + K)   and S(C)=O(K)
	public static String findOrder(String[] dict, int N, int K) {
		ArrayList<Integer>[] graph = new ArrayList[K];
		for (int i = 0; i < K; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inorder = new int[K];
		for (int i = 0; i < N - 1; i++) {
			String firstString = dict[i];
			String secondString = dict[i + 1];
			int len = Math.min(firstString.length(), secondString.length());
			for (int p = 0; p < len; p++) {
				if (firstString.charAt(p) != secondString.charAt(p)) {
					graph[firstString.charAt(p) - 'a'].add(secondString.charAt(p) - 'a');
					inorder[secondString.charAt(p) - 'a']++;
					break;
				}
			}
		}

		Queue<Integer> mq = new ArrayDeque<>();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < K; i++) {
			if (inorder[i] == 0) {
				mq.add(i);
			}
		}

		while (!mq.isEmpty()) {
			int node = mq.remove();
			ans.append((char) ('a' + node));
			for (int nbr : graph[node]) {
				inorder[nbr]--;
				if (inorder[nbr] == 0) {
					mq.add(nbr);
				}
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		String dict[] = { "baa", "abcd", "abca", "cab", "cad" };
		int length = dict.length;
		int K = 4;
		String response = findOrder(dict, length, K);
		System.out.println(response);
	}

}
