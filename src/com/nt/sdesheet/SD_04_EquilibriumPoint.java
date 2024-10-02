package com.nt.sdesheet;

public class SD_04_EquilibriumPoint {

	// T(c)=O(n) and S(C)=O(1)
	public static int equilibriumPoint(long arr[], int n) {
		int sum=0;
		for(int i=0;i<n;i++) 
			sum+=arr[i];
		int sum1=0;
		for(int j=0;j<n;j++) {
			sum-=arr[j];
			if(sum==sum1)
				return j+1;
			sum1+=arr[j];
		}	
		return -1;
	}

	public static void main(String[] args) {
		long A[] = { 1, 3, 5, 2, 2 };
		int response = equilibriumPoint(A, A.length);
		System.out.println("The Equilibrium point position is ::" + response);

	}

}
