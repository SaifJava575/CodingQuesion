package com.nt.graph;

import java.util.ArrayList;

public class Gr_03_DFSOfUndirectedGraph {

	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> dfs = new ArrayList<>();
		boolean vis[]=new boolean[V];
		dfs(0, adj, dfs, vis);
		return dfs;
	}
	static void dfs(int i,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,boolean vis[]) {
		ans.add(i);
		vis[i]=true;
		for(Integer ele:adj.get(i)) {
			if(!vis[ele]) {
				dfs(ele, adj, ans, vis);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int V = 5;
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(0).add(3);

		adj.get(1).add(0);

		adj.get(2).add(0);
		adj.get(2).add(4);

		adj.get(3).add(0);

		adj.get(4).add(2);

		ArrayList<Integer> response = dfsOfGraph(V, adj);
		System.out.println("The DFS of Graph is " + response);
	}

}
