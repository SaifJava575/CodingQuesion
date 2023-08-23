package com.nt.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Gr_20_StronglyConnectedComponenetsGraph {

	public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		// topological sort
		Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				tsort(adj, i, vis, st);
			}
		}
		// transpose of graph
		ArrayList<ArrayList<Integer>> ng = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			ng.add(i, new ArrayList<>());
		}
		for (int i = 0; i < V; i++) {
			for (int j : adj.get(i)) {
				ng.get(j).add(i);
			}
		}
		// dfs on stack ele
		int c = 0;
		boolean vis2[] = new boolean[V];
		while (!st.isEmpty()) {
			int curr = st.pop();
			if (!vis2[curr]) {
				dfs(ng, curr, vis2);
				c++;
			}
		}
		return c;
	}

	static void dfs(ArrayList<ArrayList<Integer>> ng, int curr, boolean[] vis) {
		vis[curr] = true;
		for (int i : ng.get(curr)) {
			if (!vis[i]) {
				dfs(ng, i, vis);
			}
		}
	}

	static void tsort(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[], Stack<Integer> st) {
		vis[curr] = true;
		for (int i : adj.get(curr)) {
			if (!vis[i]) {
				tsort(adj, i, vis, st);
			}
		}
		st.push(curr);
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = 5;
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());
		adj.get(0).add(2);
		adj.get(0).add(3);
		adj.get(1).add(0);
		adj.get(2).add(1);
		adj.get(3).add(4);

		int response = kosaraju(v, adj);
		System.out.println("The Connected Componenets Graph is ::" + response);

	}

}
