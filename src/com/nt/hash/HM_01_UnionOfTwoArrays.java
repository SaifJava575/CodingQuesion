package com.nt.hash;

import java.util.HashSet;
import java.util.Set;

public class HM_01_UnionOfTwoArrays {
	
	public static int doUnion(int a[], int n, int b[], int m) {
		Set<Integer> set=new HashSet<>();
		for(int i=0;i<n;i++)
			set.add(a[i]);
		for(int j=0;j<m;j++)
			set.add(b[j]);
		int size=set.size();
		return size;
			
	}

	public static void main(String[] args) {
    int a[]= {1,2,3,4,5};
    int b[]= {1,2,3};
   int n=a.length;
   int m=b.length;
   int response=doUnion(a, n, b, m);
   System.out.println("The union element is "+response);
	}

}
