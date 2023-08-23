package com.nt.file;

import java.io.ObjectStreamClass;

public class File_12_FileObjectStream {

	public static void main(String[] args) {

		ObjectStreamClass osc = ObjectStreamClass.lookup(String.class);
		System.out.println(osc.getName());

	}

}
