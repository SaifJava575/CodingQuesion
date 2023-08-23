package com.nt.dp;

public class Dp_10_PerfectSumProblem {
	
	private static long mod = (long)1e9+7;

	public static int perfectSum(int arr[], int n, int sum) {
    long[][] t = new long[n+1][sum+1];
	    
	    for(int i=0; i<=n; i++) 
	    	t[i][0]=1;	   
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(arr[i-1] <= j)
	                t[i][j] = ((t[i-1][j-arr[i-1]]%mod) + (t[i-1][j]%mod))%mod;
	            else
	                t[i][j] = t[i-1][j]%mod;	            
	        }
	    }	    
	    return (int)(t[n][sum]%mod);
	}

	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 6, 8, 10};
		int sum=10,n=arr.length;
		int response=perfectSum(arr, n, sum);
		System.out.println("The perfect sum problem is ::"+response);

	}

}
