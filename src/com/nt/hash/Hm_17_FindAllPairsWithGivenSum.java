package com.nt.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class pair {
	long first, second;

	public pair(long first, long second) {
		this.first = first;
		this.second = second;
	}
}

public class Hm_17_FindAllPairsWithGivenSum {

	public static pair[] allPairs(long A[], long B[], long N, long M, long X) {

		ArrayList<pair> arr=new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = (int) (A[i] + B[j]);
				if (sum == X) {
                 pair pairval=new pair(A[i], B[j]);
                 arr.add(pairval);
				} else if (sum < X)
					continue;
				else
					break;
			}			
		}
		pair ans[]=new pair[arr.size()];
		for(int i=0;i<arr.size();i++) {
			ans[i]=arr.get(i);
		}
		return ans;

	}
	
	 public static pair[] allPairs1( long A[], long B[], long N, long M, long X) {
	        // Your code goes here 
	        Arrays.sort(A);
	        ArrayList<pair> resArray = new ArrayList<>();
	        HashMap<Long, Long> map = new HashMap<>();
	        for(int i =0; i<M;i++){
	            if(map.containsKey(B[i])){
	                long val = map.get(B[i]);
	                val++;
	                map.put(B[i], val);
	            }else{
	                map.put(B[i], 1L);
	            }
	        }
	        for(int i =0; i<N; i++){
	            long target = X-A[i];
	            if(map.containsKey(target)){
	                pair p = new pair(A[i], target);
	                resArray.add(p);
	            }
	        }
	        pair[] results = new pair[resArray.size()];
	        for(int i =0; i<resArray.size(); i++){
	            results[i] = resArray.get(i);
	        }
	        
	        return results;
	    }

	public static void main(String[] args) {
		long A[] = { 1, 2, 4, 5, 7 };
		long B[] = { 5, 6, 3, 4, 8 };
		int X = 9;

		pair[] response = allPairs1(A, B, A.length, B.length, X);
		for (pair val : response)
			System.out.print(val.first + " "+ val.second);
	}

}
