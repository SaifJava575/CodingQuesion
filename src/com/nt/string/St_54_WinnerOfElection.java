package com.nt.string;

import java.util.SortedMap;
import java.util.TreeMap;

public class St_54_WinnerOfElection {

	
	//T(C)= O(n)   AND s(c)= O(n) 
	public static String[] winner(String arr[], int n) {
		SortedMap<String, Integer> m = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (m.containsKey(arr[i]))
				m.put(arr[i], m.get(arr[i]) + 1);
			else
				m.put(arr[i], 1);

		}
		String[] ans = new String[2];
		int max = Integer.MIN_VALUE;
		for (String name : m.keySet()) {
			int vote = m.get(name);
			if (vote > max) {
				max = vote;
				ans[0] = name;
				ans[1] = Integer.toString(vote);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String votes[] = { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny",
				"jamie", "johnny", "john" };
		int n=votes.length;
		String res[]=winner(votes, n);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

}
