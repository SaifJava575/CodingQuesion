package com.nt.hash;

import java.util.HashMap;
import java.util.Map;

public class Hm_19_LongestKuniqueSubString {

	public static int longestkSubstr(String s, int k) {
		// code here
		char c[] = s.toCharArray();
		int i = 0, j = 0;
		int n = s.length();
		int max=-1;
		Map<Character, Integer> map = new HashMap<>();
		while (j < n) {
				map.put(c[j], map.getOrDefault(c[j], 0) + 1);
			if (map.size() < k)
				j++;
			else if (map.size() == k) {
				max=Math.max(max, j-i+1);
				j++;
			}else if(map.size()>k) {
				while(map.size()>k) {
					map.put(c[i], map.get(c[i])-1);
					if(map.get(c[i])==0)
						map.remove(c[i]);
					i++;
				}
				j++;
			}
				
		}
		return max;
	}
	
	public static void main(String[] args) {

		String S = "aabacbebebe";
		int K = 3;
		int response = longestkSubstr(S, K);
		System.out.println("Longest SubString with K distinct Character ::" + response);
	}

}
