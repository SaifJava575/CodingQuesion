package com.nt.hard;

public class Hd_41_BitsDifference {

	// T(C)=O(N * log2(Max(Ai)) and S(C)=O(1)
	static int countBits(int N, long A[]) {
		 long total = 0;
	        int mod = 1000000007;
	        for(int i = 1; i<= 31; i++){
	            long set  = 0;
	            long unset = 0;
	            for(int j = 0; j < A.length; j++){
	                if(A[j]%2 == 1){
	                    set++;
	                }else{
	                    unset++;
	                }
	                A[j] = A[j] >> 1;
	            }
	            total = total + (set * unset * 2);
	        }
	        return (int)(total%mod);
	}

	public static void main(String[] args) {
		long A[] = { 1, 3, 5 };
		int n = A.length;
		int response = countBits(n, A);
		System.out.println("Count the Difference bit is ::" + response);

	}

}
