package com.nt.ninja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nj_21_UniquePrimeFactors {
    public static List<Integer> countPrimes(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        
        // Check for number of 2s that divide n
        if (n % 2 == 0) {
            primeFactors.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        // Check for odd factors from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                primeFactors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        // If n is a prime number greater than 2
        if (n > 2) {
            primeFactors.add(n);
        }

        return primeFactors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Input number N
        List<Integer> primeFactors = countPrimes(n);
        
        for (int i = 0; i < primeFactors.size(); i++) {
            System.out.print(primeFactors.get(i) + (i < primeFactors.size() - 1 ? " " : ""));
        }
        System.out.println();
        scanner.close();
    }
}
