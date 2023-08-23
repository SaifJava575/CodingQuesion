package com.nt.arrays;

import java.util.ArrayList;

public class Ar_24_StockBuyAndSell {

	public static ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
		ArrayList<ArrayList<Integer>> response = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			if (arr[i + 1] > arr[i]) {
				list.add(i);
				list.add(i + 1);
				response.add(list);
			}
			
		}
		return response;
	}

	public static void main(String[] args) {
	
	  int A[] = {100,180,260,310,40,535,695};
	  ArrayList<ArrayList<Integer>> response=stockBuySell(A, A.length);
	  System.out.println("The response is::"+response);
	}

}
