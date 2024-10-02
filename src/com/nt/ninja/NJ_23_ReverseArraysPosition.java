package com.nt.ninja;

import java.util.ArrayList;
import java.util.Collections;

public class NJ_23_ReverseArraysPosition {
	
	public static void reverseArray(ArrayList<Integer> ARR, int M)
    {
		 if (M < 0 || M >= ARR.size() - 1) {
	            return; // No need to reverse if M is out of bounds
	        }

	        
	        int left = M + 1;
	        int right = ARR.size() - 1;

	        while (left < right) {
	            // Swap elements at left and right
	            Collections.swap(ARR, left, right);
	            // Move towards the center
	            left++;
	            right--;
	        } 
    }

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>();
		Collections.addAll(arr, 1,2,3,4,5,6,7);
		for(int i=1;i<7;i++)
		arr.add(i);
		int m=3;
		reverseArray(arr, m);

	}

}
