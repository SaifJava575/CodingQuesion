package com.nt.string;

import java.util.ArrayList;
import java.util.HashMap;

public class St_50_PossibleWorddsPhoneDigits {

	// T(C)=O(4^N * N) and S(C)=O(N)
	public static void number(int a[], int i, HashMap<Integer, String> map, StringBuilder str, ArrayList<String> arr) {
		if (str.length() == a.length) {
			String ss = str.toString();
			arr.add(ss);
			return;
		}
		String cur = map.get(a[i]);
		for (int j = 0; j < cur.length(); j++) {
			str.append(cur.charAt(j));
			number(a, i + 1, map, str, arr);
			str.deleteCharAt(str.length() - 1);
		}
	}

	public static ArrayList<String> possibleWords(int a[], int N) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		ArrayList<String> arr = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		number(a, 0, map, str, arr);
		return arr;
	}

	static ArrayList<String> possibleWords1(int a[], int N) {
		char[][] keypad = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < keypad[a[0] - 2].length; i++) {
			String ds = keypad[a[0] - 2][i] + "";
			findPossibleWord(keypad, a, 1, res, ds);
		}
		return res;
	}

	static void findPossibleWord(char[][] keypad, int[] arr, int index, ArrayList<String> res, String ds) {
		if (index >= arr.length) {
			res.add(ds);
			return;
		}
		for (int i = 0; i < keypad[arr[index] - 2].length; i++) {
			String ds1 = ds + keypad[arr[index] - 2][i];
			findPossibleWord(keypad, arr, index + 1, res, ds1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4 };
		int N = arr.length;
		ArrayList<String> res = possibleWords1(arr, N);
		
		for (String ans : res) {
			System.out.print(ans + " ");
		}

	}

}
