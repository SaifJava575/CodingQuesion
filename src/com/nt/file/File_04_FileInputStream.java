package com.nt.file;

import java.io.FileInputStream;
import java.io.IOException;

public class File_04_FileInputStream {

	public static void fileInput(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		int res = 0;
		while ((res = fis.read()) != -1) {
			System.out.print((char) res);
		}

		fis.close();
	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		fileInput(path);

	}

}
