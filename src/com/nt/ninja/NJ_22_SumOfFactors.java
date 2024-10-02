package com.nt.ninja;
import java.util.ArrayList;
import java.util.Scanner;

public class NJ_22_SumOfFactors {
    public static ArrayList<Integer> sumOfFactors(ArrayList<Integer> arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            int sum = 0;
            // Calculate the sum of factors of num
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sum += i; // i is a factor
                    if (i != num / i) {
                        sum += num / i; // add the complementary factor
                    }
                }
            }
            list.add(sum);
        }
        
        return list;
    }

    public static void main(String[] args) {
       ArrayList<Integer> arr=new ArrayList<>();
       arr.add(20);
       arr.add(11);
       ArrayList<Integer> res=sumOfFactors(arr);
       System.out.println(res);
       
    }
}
