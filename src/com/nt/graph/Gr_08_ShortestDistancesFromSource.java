package com.nt.graph;
import java.util.*;

class Graph {
    private int V;
    private List<List<int[]>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new int[]{v, weight});
        adj.get(v).add(new int[]{u, weight}); // Since the graph is undirected
    }

    public int[] shortestDistancesFromSource(int source) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{source, 0});
        distances[source] = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0];
            int distance = curr[1];

            if (distance > distances[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = distance + weight;

                if (newDistance < distances[nextNode]) {
                    distances[nextNode] = newDistance;
                    minHeap.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        return distances;
    }
}

public class Gr_08_ShortestDistancesFromSource {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        Graph graph = new Graph(V);

        // Example graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        int source = 0; // Source vertex S

        int[] shortestDistances = graph.shortestDistancesFromSource(source);

        // Printing the shortest distances from the source vertex S
        System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }
}
