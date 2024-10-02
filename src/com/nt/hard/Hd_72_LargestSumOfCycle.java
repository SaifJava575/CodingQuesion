package com.nt.hard;

public class Hd_72_LargestSumOfCycle {

	static long cyclesum = -1;

	// T(C)= O(N) and S(C)= O(N)
	public static long largesSumCycle(int N, int Edge[]) {
		boolean visited[] = new boolean[N];
		boolean pathvisited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				dfs(i, Edge, visited, pathvisited);
		}
		return cyclesum;

	}

	public static void dfs(int node, int[] Edge, boolean[] visited, boolean[] pathvisited) {
		visited[node] = true;
		pathvisited[node] = true;
		if (Edge[node] != -1) {
			int adj = Edge[node];
			if (!visited[adj])
				dfs(adj, Edge, visited, pathvisited);
			else if (pathvisited[adj]) {
				int curr = adj;
				long sum = 0;
				do {
					sum += curr;
					curr = Edge[curr];

				} while (curr != adj);
				cyclesum = Math.max(cyclesum, sum);
			}
		}
		pathvisited[node] = false;
	}

	public static void main(String[] args) {

		int Edge[] = {2, 0, -1, 2} ;//{ 1, 2, 0, -1 };
		long response = largesSumCycle(Edge.length, Edge);
		System.out.println("Largest Sum of Cycle is ::" + response);
	}

}
