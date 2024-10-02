package com.nt.hard;

import java.util.ArrayList;
import java.util.List;

public class Hd_37_ArticulationPointsFinder {

	// T(c)= O(V + E) and S(c)= O(V)
	public static List<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		int tin[] = new int[V];
		int low[] = new int[V];
		int mark[] = new int[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, -1, 1, adj, visited, tin, low, mark);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (mark[i] == 1)
				ans.add(i);
		}
		if (ans.size() == 0)
			ans.add(-1);
		return ans;
	}

	public static void dfs(int node, int parent, int timer, ArrayList<ArrayList<Integer>> adj, boolean visited[],
			int tin[], int low[], int mark[]) {
		visited[node] = true;
		tin[node] = low[node] = timer;
		timer++;
		int child = 0;
		for (int adjNode : adj.get(node)) {
			if (adjNode == parent)
				continue;
			if (!visited[adjNode]) {
				dfs(adjNode, node, timer, adj, visited, tin, low, mark);
				low[node] = Math.min(low[node], low[adjNode]);
				if (low[adjNode] >= tin[node] && parent != -1) {
					mark[node] = 1;
				}
				child++;
			} else
				low[node] = Math.min(low[node], tin[adjNode]);
		}
		if (parent == -1 && child > 1)
			mark[node] = 1;
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(1);
		adj.get(3).add(4);
		adj.get(4).add(3);

		List<Integer> result = articulationPoints(V, adj);
		System.out.println("Articulation Points: " + result);
	}
}
