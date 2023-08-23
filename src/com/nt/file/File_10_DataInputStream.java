package com.nt.file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class File_10_DataInputStream {

	public static void dataInputStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		DataInputStream dis = new DataInputStream(fis);
		int res = dis.readInt();
		System.out.println(res);
		

		fis.close();
		dis.close();
	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		dataInputStream(txt);

	}

}
