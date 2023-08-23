package com.nt.string;

public class St_73_NearestMultipleOf10String {

	public static String roundToNearest(String N) {
		int num = Integer.valueOf(N);
		int divide = num / 10;
		int rem = num % 10;
		int res = 0;
		if (rem <= 5)
			res = divide * 10;
		else
			res = (divide + 1) * 10;
		String result = String.valueOf(res);
		return result;
	}

	public static String roundToNearest1(String N) {
		char[] number = N.toCharArray();
		int n = number.length;
		char c = number[n - 1];
		number[n - 1] = '0';
		if (c > '5') {
			int i = n - 2;
			while ((i >= 0) && (number[i] == '9'))
				number[i--] = '0';

			if (i < 0)
				return ("1" + new String(number));

			number[i] += 1;
		}
		return (new String(number));
	}

	public static void main(String[] args) {
		String num = "32986";
		String res = roundToNearest1(num);
		System.out.println("Nearest Number round is::" + res);
	}

}
