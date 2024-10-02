package com.nt.hard;

import java.util.Arrays;

public class Hd_01_MergeWithOutExtraSpace {

	// T(C)= O((n+m) log(n+m)) and S(C)=O(1)
	public static void merge(long arr1[], long arr2[], int n, int m) {

		long res[] = new long[n + m];
		long a[] = new long[n];
		long b[] = new long[m];
		int j = 0;
		for (int i = 0; i < n; i++) {
			res[j] = arr1[i];
			j++;
		}
		for (int i = 0; i < m; i++) {
			res[j] = arr2[i];
			j++;
		}

		Arrays.sort(res);

		for (int i = 0; i < n; i++)
			a[i] = res[i];
		int c = 0;
		for (int i = m - 1; i < res.length; i++) {
			b[c] = res[i];
			c++;
		}

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

		System.out.println();
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");

	}
	//T(C)-=O((n+m) log(n+m))  and S(C)=O(1)
	public static void merge1(long arr1[], long arr2[], int n, int m) 
    {
        int start = 0;
        int end = arr1.length-1;
        while (end >= 0 && start < arr2.length){
            if (arr2[start] < arr1[end]){
                long temp = arr2[start];
                arr2[start] = arr1[end];
                arr1[end] = temp;
                start++;
                end--;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        for(long i:arr1)
        	System.out.print(i+" ");
        System.out.println();
        for(long i:arr2)
        	System.out.print(i+" ");
    }

	public static void main(String[] args) {
		long arr1[] = { 1, 3, 5, 7 };
		long arr2[] = { 0, 2, 6, 8, 9 };
		int n = arr1.length;
		int m = arr2.length;
		merge1(arr1, arr2, n, m);

	}

}
