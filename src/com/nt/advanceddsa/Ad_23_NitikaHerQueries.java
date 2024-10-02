package com.nt.advanceddsa;

import java.util.ArrayList;
import java.util.List;

public class Ad_23_NitikaHerQueries {

	static List<Integer> specialXor(int N, int Q, int a[], int query[][]) {
		List<Integer> ans=new ArrayList();
        int[] prefix=new int[N];
        prefix[0]=a[0];
        for(int i=1;i<N;i++)
        {
            prefix[i]=a[i]^prefix[i-1];
        }
        for(int i=0;i<query.length;i++)
        {
            int x=query[i][0]-1;
            int y=query[i][1]-1;
             ans.add(prefix[prefix.length-1]^prefix[y]^prefix[x]^a[x]);
        }
        return ans;
	}

	public static void main(String[] args) {
		int[] a = { 4, 7, 8, 5, 9, 6, 1, 0, 20, 10 };
		int[][] query = { { 3, 8 }, { 1, 6 }, { 2, 3 } };
		int N = a.length;
		int q = 3;
		List<Integer> response = specialXor(N, q, a, query);
		System.out.println(response);

	}

}
