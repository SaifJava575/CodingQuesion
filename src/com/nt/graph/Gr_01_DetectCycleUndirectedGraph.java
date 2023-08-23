package com.nt.graph;

import java.util.ArrayList;

public class Gr_01_DetectCycleUndirectedGraph {

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean vsited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vsited[i])
				if (dfs(i, adj, vsited, -1))
					return true;
		}
		return false;
	}

	public static boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
		visited[src] = true;
		for (int v : adj.get(src)) {
			if (!visited[v])
				if (dfs(v, adj, visited, src))
					return true;
				else if (v != parent)
					return true;

		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int v = 5;
		for (int i = 0; i < v; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);

		adj.get(1).add(0);
		adj.get(1).add(4);
		adj.get(1).add(2);

		adj.get(2).add(1);
		adj.get(2).add(3);

		adj.get(3).add(2);
		adj.get(3).add(4);

		adj.get(4).add(1);
		adj.get(4).add(3);

		if (isCycle(v, adj))
			System.out.println("Detect Cycle");
		else
			System.out.println("Cycle is not exist");

	}

}
