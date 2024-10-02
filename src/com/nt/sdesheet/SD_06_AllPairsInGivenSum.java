package com.nt.sdesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class pair {
	long first, second;

	public pair(long first, long second) {
		this.first = first;
		this.second = second;
	}
}

public class SD_06_AllPairsInGivenSum {

	public static pair[] allPairs(long A[], long B[], long N, long M, long X) {
		  List<pair> pairs = new ArrayList<>();
	        Arrays.sort(A);
	        Arrays.sort(B);        
	        int i = 0, j = (int)M - 1;
	        while (i < N && j >= 0) {
	            long sum = A[i] + B[j];
	            if (sum == X) {
	                pairs.add(new pair(A[i], B[j]));
	                i++;
	                j--;
	            } else if (sum < X) {
	                i++;
	            } else {
	                j--;
	            }
	        }
	        
	        pair[] result = new pair[pairs.size()];
	        result = pairs.toArray(result);
	        return result;
	}

	public static void main(String[] args) {
		long A[] = {1, 2, 4, 5, 7};
		long B[] = {5, 6, 3, 4, 8} ;
		long X = 9;
		
		pair[] response=allPairs(A, B, A.length, B.length, X);
		for(pair val:response)
			System.out.println(val.first+" "+val.second);
	}

}
