package com.nt.sdesheet;

import java.util.Arrays;

public class SD_22_MinmumPlatformsRequired {

	//T(C)=O O(nLogn)  and S(C)=O(n)
	static int findPlatform(int arr[], int dep[], int n) {
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
		int response = findPlatform(arr, dep, n);
		System.out.println("Minmum platform required ::" + response);
	}

}
