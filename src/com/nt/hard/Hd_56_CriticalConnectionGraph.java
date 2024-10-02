package com.nt.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hd_56_CriticalConnectionGraph {


	public static ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {
		// Code here
        boolean visited[] = new boolean[v];
		int parent = -1;
		int disc[] = new int[v];
		int low[] = new int[v];
		
		int timer = 0;
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				dfs(i,parent,timer,disc,low,ans,visited,adj);
			}
		}
		
		//sort 
		for(ArrayList<Integer> a : ans){
		    Collections.sort(a);
		}
		Collections.sort(ans,new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a,ArrayList<Integer> b) {
				if((a.get(0)-b.get(0))==0){
				    return a.get(1)-b.get(1);
				}
				return a.get(0)-b.get(0);
			}
		});
		
		return ans;
	}

	 private static void dfs(int node, int parent, int timer, int[] disc, int[] low, ArrayList<ArrayList<Integer>> ans,
				boolean[] visited, ArrayList<ArrayList<Integer>> list) {
			
			visited[node] = true;
			disc[node] = timer;
			low[node] = timer;
			timer++;
			for(Integer val : list.get(node)) {
				if(val == parent) {
					continue;
				}
				if(!visited[val]) {
					dfs(val, node, timer, disc, low, ans, visited, list);
					low[node] = Math.min(low[node],low[val]);
					if(low[val]>disc[node]) {
						ArrayList<Integer> a = new ArrayList<>();

						a.add(node);
						a.add(val);
						ans.add(a);
					}
				}else {

					low[node] = Math.min(low[node], disc[val]);
				}
			}
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

		ArrayList<ArrayList<Integer>> result = criticalConnections(V, adj);
		System.out.println("Critical Connections:");
		for (List<Integer> edge : result) {
			System.out.println(edge.get(0) + " - " + edge.get(1));
		}
	}

}
