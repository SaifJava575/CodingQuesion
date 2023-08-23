package com.nt.graph;

import java.util.ArrayList;

public class Gr_14_PrintAdjacencyList {

	public static ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		 for(int i=0;i<V;i++){
		        adj.get(i).add(0,i);
		    }
		        return adj;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
		int V=5;
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(0).add(4);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(1).add(4);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(1);
		adj.get(3).add(2);
		adj.get(3).add(4);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(4).add(3);
		
		ArrayList<ArrayList<Integer>> response=printGraph(V, adj);
	    for(ArrayList<Integer>ele:response)
	    	for(Integer val:ele)
	    		System.out.print(val+"->");
	    System.out.println();
		
	}

}
