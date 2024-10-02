package com.nt.sdesheet;

public class SD_07_ConvertArraysZigzagFashion {

	//T(C)=O(n)   and S(C)=O(1)
	public static void zigZag(int a[], int n) {
		for(int i=0; i<n-1; i++){
            if(i%2==0 && a[i]>a[i+1]) swap(a,i,i+1);
            else if(i%2==1 && a[i]<a[i+1]) swap(a,i,i+1);
        }
	}
	
	  public static void swap(int array[], int a, int b){
	        int temp=array[a];
	        array[a] = array[b];
	        array[b] = temp;
	    }

	public static void main(String[] args) {
	
			int Arr[] = {4, 3, 7, 8, 6, 2, 1};
			int n=Arr.length;
			zigZag(Arr, n);
			for(int i=0;i<Arr.length;i++)
				System.out.print(Arr[i]+" ");
			

	}

}
