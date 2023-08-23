package com.nt.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Gr_23_BellmanFordAlgorithm {

	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
		int[] distance = new int[V];
		Arrays.fill(distance, 100000000); // Initialize distances to a large value
		distance[S] = 0; // Distance to source vertex is 0

		// Relax edges V-1 times
		for (int i = 1; i < V; i++) {
			for (ArrayList<Integer> edge : edges) {
				int u = edge.get(0);
				int v = edge.get(1);
				int w = edge.get(2);

				if (distance[u] != 100000000 && distance[u] + w < distance[v]) {
					distance[v] = distance[u] + w;
				}
			}
		}

		// Check for negative cycles
		for (ArrayList<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int w = edge.get(2);

			if (distance[u] != 100000000 && distance[u] + w < distance[v]) {
				return new int[] { -1 };
			}
		}

		return distance;
	}

	public static void main(String[] args) {
		int V = 3; // Number of vertices
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 0, 1)));
        
        int S = 2; // Source vertex
        
        int[] result = bellman_ford(V, edges, S);
        for (int distance : result) {
            System.out.print(distance + " ");
        }
	}

}
