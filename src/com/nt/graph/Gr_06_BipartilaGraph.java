package com.nt.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Gr_06_BipartilaGraph {

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[V];
		int[] color = new int[V];

		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				color[i] = 1;
				while (!q.isEmpty()) {
					int node = q.peek();
					q.remove();
					vis[node] = 1;
					for (Integer it : adj.get(node)) {
						if (vis[it] == 0) {
							q.add(it);
							if (color[node] == 1)
								color[it] = 2;
							else
								color[it] = 1;

						} else {
							if (color[it] == color[node])
								return false;
						}
					}
				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int Ver =3;
		for (int i = 0; i < Ver; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		//adj.get(2).add(3);
		//adj.get(3).add(2);
		
		if(isBipartite(Ver, adj))
			System.out.println("Tree is Bipartial Graph");
		else 
			System.out.println("Tree is not Bipartial Graph");
	}

}
