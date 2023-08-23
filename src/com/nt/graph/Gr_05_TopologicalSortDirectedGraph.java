package com.nt.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Gr_05_TopologicalSortDirectedGraph {

	static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i])
				dfs(i, adj, visited, stack);

		}

		int[] ans = new int[v];
		int i = 0;
		while (!stack.isEmpty()) {
			ans[i++] = stack.peek();
			stack.pop();
		}
		return ans;
	}

	static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
		if (visited[node])
			return;
		visited[node] = true;
		for (int edge : adj.get(node)) {
			dfs(edge, adj, visited, stack);
		}
		stack.push(node);
	}

	public static void main(String[] args) {
  
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int Ver = 4;
		for (int i = 0; i < Ver; i++)
			adj.add(new ArrayList<>());
		
		adj.get(1).add(0);
		adj.get(2).add(0);
		adj.get(3).add(0);
		
		int[] response=topoSort(Ver, adj);
		for(int ele:response)
			System.out.print(ele+" ");

	}

}
