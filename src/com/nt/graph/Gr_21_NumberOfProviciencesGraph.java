package com.nt.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Gr_21_NumberOfProviciencesGraph {

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
		int provinces = 0;
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				provinces++;
				dfs(i, V, adj, visited);
			}
		}

		return provinces;
	}

	static void dfs(int node, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		visited[node] = true;
		for (int neighbor : adj.get(node)) {
			if (!visited[neighbor]) {
				dfs(neighbor, V, adj, visited);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
		graph1.add(new ArrayList<Integer>() {
			{
				add(1);
				add(0);
				add(1);
			}
		});
		graph1.add(new ArrayList<Integer>() {
			{
				add(0);
				add(1);
				add(0);
			}
		});
		graph1.add(new ArrayList<Integer>() {
			{
				add(1);
				add(0);
				add(1);
			}
		});

		int response = numProvinces(graph1, 3);
		System.out.println("Number of Provience of the City " + response);
	}

}
