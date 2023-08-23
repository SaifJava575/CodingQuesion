package com.nt.arrays;

public class Ar_14_TrappingRainWater {
	
	//T(c)=O(n)  and S(C)=O(1)
	public static int trappingWater(int arr[], int n) { 
        int min=Math.min(arr[0], arr[n-1]);
        int trapped_rain=0;
        for(int i=1;i<n-1;i++) {
        	if(min>arr[i])
        		trapped_rain+=(min-arr[i]);
        }
        return trapped_rain;
    }
	
	//T(c)=O(n)  and S(C)=O(n)
	public static long trappingWater1(int arr[], int n) { 
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = arr[0];
        for (int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        
        rightMax[n-1] = arr[n-1];
        for (int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }
        
        long ans = 0;
        for (int i=0; i<n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        
        return ans;
    } 

	public static void main(String[] args) {
		int arr[] = {7,4,0,9};
		int n=arr.length;
		long res=trappingWater1(arr, n);
		System.out.println("Trapping RainWater is::"+res);

	}

}
