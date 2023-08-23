package com.nt.graph;

import java.util.*;

public class Gr_09_ShortestDistancesFromSource {

	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		int[] distances = new int[V];
		Arrays.fill(distances, Integer.MAX_VALUE);

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		minHeap.offer(new int[] { S, 0 });
		distances[S] = 0;

		while (!minHeap.isEmpty()) {
			int[] curr = minHeap.poll();
			int node = curr[0];
			int distance = curr[1];

			if (distance > distances[node]) {
				continue;
			}

			for (ArrayList<Integer> neighbor : adj.get(node)) {
				int nextNode = neighbor.get(0);
				int weight = neighbor.get(1);
				int newDistance = distance + weight;

				if (newDistance < distances[nextNode]) {
					distances[nextNode] = newDistance;
					minHeap.offer(new int[] { nextNode, newDistance });
				}
			}
		}

		return distances;
	}

	public static void main(String[] args) {
		int V = 5; // Number of vertices in the graph
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		// Example graph
		adj.get(0).add(new ArrayList<>(Arrays.asList(1, 4)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(2, 1)));
		adj.get(1).add(new ArrayList<>(Arrays.asList(3, 1)));
		adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));
		adj.get(2).add(new ArrayList<>(Arrays.asList(3, 5)));
		adj.get(3).add(new ArrayList<>(Arrays.asList(4, 3)));

		int source = 0; // Source vertex S

		int[] shortestDistances = dijkstra(V, adj, source);

		// Printing the shortest distances from the source vertex S
		System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
		for (int i = 0; i < V; i++) {
			System.out.println("Vertex " + i + ": " + shortestDistances[i]);
		}
	}
}
