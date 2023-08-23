package com.nt.graph;

import java.util.ArrayList;

public class Gr_02_DetectCycleInDirectedGraph {
	
	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean vis[]=new boolean[V];
		boolean pathVis[]=new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!vis[i])
				if(dfs(adj, vis, pathVis, i))
					return true;
				
		}
       return false;
    }
	public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean pathVis[],int node) {
		vis[node]=true;
		pathVis[node]=true;
		for(Integer it:adj.get(node)) {
			if(!vis[it]) {
				if(dfs(adj, vis, pathVis, it))
				return true;
			}else if(pathVis[it])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		int V=4;
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(3);
		
		if(isCyclic(V, adj))
			System.out.println("Cycle is Detetced in Directed Graph");
		else
			System.out.println("Cycle is not Detected in Directed Graph");



		

	}

}
