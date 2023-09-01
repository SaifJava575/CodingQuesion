package com.nt.hash;

import java.util.HashMap;
import java.util.Map;

public class Hm_09_FirstRepeatingElement {

	public static int firstRepeated(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {			
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])>1)
				return i+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 3, 4, 3, 5, 6 };
		int n = arr.length;
		int response = firstRepeated(arr, n);
		System.out.println("First Repeating Charcter is::" + response);
	}

}
