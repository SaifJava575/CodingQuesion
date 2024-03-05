package com.nt.hard;

import java.util.HashSet;

public class Hd_64_VertexCover {

	static int ans = Integer.MAX_VALUE;

	// T(C)=O(M*2^N) and S(C)=O(N^2)
	public static int vertexCover(int n, int m, int[][] edges) {
		ans = Integer.MAX_VALUE;
		solveRec(1, n, edges, new HashSet<>());
		return ans;
	}

	public static void solveRec(int currentNode, int V, int[][] edges, HashSet<Integer> set) {

		if (currentNode > V) {
			for (int i = 0; i < edges.length; i++) {
				int u = edges[i][0];
				int v = edges[i][1];

				if (!set.contains(u) && !set.contains(v))
					return;
			}

			ans = Math.min(ans, set.size());
			return;
		}

		// don't take currentNode
		solveRec(currentNode + 1, V, edges, set);
		// take currentNode
		set.add(currentNode);
		solveRec(currentNode + 1, V, edges, set);
		set.remove(currentNode);
	}

	public static void main(String[] args) {
		int N = 5;
		int M = 6;
		int edges[][] = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };
		int response = vertexCover(N, M, edges);
		System.out.println("The maximum Vertext cover is ::" + response);
	}

}
