package com.nt.string;

public class St_47_ExcelColumn {

	//T(C)=O(Log(N))  AND S(c)=O(Log(N))
	public static String excelColumn(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int remainder = (n - 1) % 26;
			sb.append((char) (65 + remainder));
			n = (n - 1) / 26;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
      int input=51;
      String res=excelColumn(input);
      System.out.println("The Excel Column number is::"+res);
	}

}
