package com.nt.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Gr_13_MinSpannigTree {
	
	static int spanningTree(int V, int E, int edges[][]) {
	       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	       
	       for(int i = 0; i<V; i++){
	           adj.add(new ArrayList<>());
	       }
	       
	       for(int i = 0; i<E; i++){
	           int u = edges[i][0];
	           int v = edges[i][1];
	           int weight = edges[i][2];
	           adj.get(u).add(new Pair(v,weight));
	           adj.get(v).add(new Pair(u,weight));
	       }
	       boolean visited[] = new boolean[V];
	       PriorityQueue<Pair> pq = new PriorityQueue<>(new WtComparator());
	       pq.add(new Pair(0,0));
	       
	       int ans = 0;
	       while(!pq.isEmpty()){
	           Pair curr = pq.poll();
	           int node = curr.node;
	           int weight = curr.weight;
	           
	           if(visited[node]){
	               continue;
	           }
	           visited[node] = true;
	           ans += weight;
	           for(Pair element: adj.get(node)){
	               if(!visited[element.node]){
	                   pq.add(new Pair(element.node, element.weight));
	               }
	           }
	       }
	       return ans;
	    }
	    
	    static class Pair{
	    int node;
	    int weight;
	    Pair(int node, int weight){
	        this.node = node;
	        this.weight = weight;
	        
	    }
	}
	static class WtComparator implements Comparator<Pair>{
	    public int compare(Pair value1, Pair value2){
	        return value1.weight - value2.weight;
	    }
	}
	
	public static void main(String[] args) {
		int V = 3, E = 3;
		int edges[][] = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
		int response = spanningTree(V, E, edges);
		System.out.println("The Spanning Tree Distance is ::" + response);

	}

}
