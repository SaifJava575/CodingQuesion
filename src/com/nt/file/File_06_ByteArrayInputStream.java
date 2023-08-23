package com.nt.file;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class File_06_ByteArrayInputStream {

	public static void byteArrayInputStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		int res = 0;
		byte[] info = new byte[1024];
		while ((res = fis.read()) != -1) {
			info[res]++;
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(info);
		int k = 0;
		while ((k = bais.read()) != -1) {
			System.out.print((char) k);
		}
		fis.close();
		bais.close();
		System.out.println("Successfully read the data from file..........");
	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		byteArrayInputStream(path);

	}

}
