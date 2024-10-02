package com.nt.advanceddsa;

public class Ad_15_XORGivenRange {

	//T(C)=O(n)  and S(C)=O(1)
	public static int getXor(int[] nums, int a, int b) {
		int res = 0;
		for (int i = a; i <= b; i++)
			res^=nums[i];
		return res;

	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 7, 9, 11 };
		int a = 1, b = 3;
		int response = getXor(nums, a, b);
		System.out.println("The Expected output is :" + response);
	}

}
