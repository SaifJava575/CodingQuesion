package com.nt.string;

public class St_79_WifiRange {

	//T(C)=O(N)  and S(C)=O(1)
	public static boolean wifiRange(int N, String S, int X) {
		int range = 0;
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == '1')
				range = X;
			else
				range--;

			if (range < -X)
				return false;
		}
		if (range < 0)
			return false;

		return true;
	}

	public static void main(String[] args) {
		int N = 5, X = 1;
		String S = "10010";
		if (wifiRange(N, S, X))
			System.out.println("Available");
		else
			System.out.println("Not Avalbale");
	}

}
