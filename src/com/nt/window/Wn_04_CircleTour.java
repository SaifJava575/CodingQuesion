package com.nt.window;

public class Wn_04_CircleTour {

	// T(c)=O(N) and S(C)=O(1)
	public static int tour(int petrol[], int distance[]) {
		int n = petrol.length;
		int balance = 0;
		int shortage = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			balance += petrol[i] - distance[i];
			if (balance < 0) {
				shortage += balance;
				start = i + 1;
				balance = 0;
			}
		}
		return balance + shortage >= 0 ? start : -1;
	}

	public static void main(String[] args) {
		int Petrol[] = { 4, 6, 7, 4 };
		int Distance[] = { 6, 5, 3, 5 };
		int response = tour(Petrol, Distance);
		System.out.println("Posibility of Circular Tour " + response);

	}

}
