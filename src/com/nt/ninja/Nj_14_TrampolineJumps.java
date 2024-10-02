package com.nt.ninja;

public class Nj_14_TrampolineJumps {
    public static int minJumpsToReachEnd(int[] arr, int n) {
        if (n == 1) return 0; // Already at the last shop
        
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest shop we can reach from current shop
            farthest = Math.max(farthest, i + arr[i]);
            
            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++; // Take a jump
                currentEnd = farthest; // Update the range to farthest reachable
                
                // If we reached or passed the last shop
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
            
            // If the farthest shop is less than or equal to the current shop, we are stuck
            if (farthest <= i) {
                return -1; // Impossible to reach the last shop
            }
        }
        
        return -1; // If the loop ends and we haven't reached the last shop
    }

    public static void main(String[] args) {
          int Arr[]= {2,1,3,2,4};
          int N=Arr.length;
            
            System.out.println(minJumpsToReachEnd(Arr, N));
       
    }
}
