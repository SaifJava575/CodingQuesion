package com.nt.imp;

import java.util.ArrayList;
import java.util.List;

public class Imp_02_ListtoStringDataConversion {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("sksaifuddin.pdf");
		 list.add("I am a good boy");
		 list.add("I am a professional Full Stack Java Developer");
		System.out.println(list);

		String str = list.toString();
		System.out.println(str);

	}

}
