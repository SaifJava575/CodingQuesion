package com.nt.hash;

import java.util.HashSet;

public class Hm_14_IntersectionOfTwoArraysCount {
	
	//T(C)=O(n + m).  and S(C)=O(min(n,m))
	 public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
	       HashSet<Integer>s=new HashSet<>();
	       for(int e:b)s.add(e);
	       HashSet<Integer> set=new HashSet<>();
	       for(int c:a) {
	    	   if(s.contains(c))
	    		   set.add(c);
	       }
	       return set.size();
	    }

	public static void main(String[] args) {
			
		int	a[] = {1, 2, 3, 4, 5, 6};
		int b[] = {3, 4, 5, 6, 7} ;
		int n=a.length;
		int m=b.length;
		int count=NumberofElementsInIntersection(a, b, n, m);
		System.out.println("Count of Common Element is ::"+count);

	}

}
