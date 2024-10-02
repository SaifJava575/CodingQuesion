package com.nt.hash;

import java.util.Map;
import java.util.TreeMap;

public class Hm_12_LimitedRangeArrays {

	//T(c)=O(n)  and S(c)=O(N)
	public static void frequencyCount(int arr[], int N, int P) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}
		for(int i=0;i<N;i++) {
			if(map.containsKey(i+1))
				arr[i]=map.get(i+1);
			else
				arr[i]=0;
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		

	}

	public static void main(String[] args) {
		int arr[] = {3,3,3,3};
		int n = arr.length;
		int p = n;
		frequencyCount(arr, n, p);
	}

}
