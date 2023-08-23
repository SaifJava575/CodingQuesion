package com.nt.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Gr_03_BFSDirectedGraph {

	//T(c)= O(V + E) and S(C)=O(v)
	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[V];
		ArrayList<Integer> list = new ArrayList<>();
		q.add(0);
		vis[0] = true;
		while (!q.isEmpty()) {
			int node = q.poll();
			list.add(node);
			for (Integer e : adj.get(node)) {
				if (!vis[e]) {
					vis[e] = true;
					q.add(e);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int V = 5;
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(0).add(3);

		adj.get(2).add(4);

		ArrayList<Integer> response = bfsOfGraph(V, adj);
		System.out.println("The BFS of Graph is " + response);

	}

}
