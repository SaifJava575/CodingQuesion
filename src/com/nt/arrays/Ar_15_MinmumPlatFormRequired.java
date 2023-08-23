package com.nt.arrays;

import java.util.Arrays;

public class Ar_15_MinmumPlatFormRequired {

	//T(c)=O(nLogn) and S(c)=O(n)
	public static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1, j = 0;
		int plat_form_need = 1, max_plat_form_need = 1;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				plat_form_need++;
				i++;
			} else if (arr[i] > dep[j]) {
				plat_form_need--;
				j++;
			}
			if (plat_form_need > max_plat_form_need)
				max_plat_form_need = plat_form_need;
		}
		return max_plat_form_need;

	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;
		int res = findPlatform(arr, dep, n);
		System.out.println("Min plat Form Need is::" + res);
	}

}
