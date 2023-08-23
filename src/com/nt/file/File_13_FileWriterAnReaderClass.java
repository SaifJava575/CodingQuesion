package com.nt.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_13_FileWriterAnReaderClass {

	public static void fileWriter(String path) throws Exception {
		FileWriter fw = new FileWriter(path);
		fw.write("Hellow! Good Morning");
		fw.append('S');
		fw.write(65);

		fw.close();
	}

	public static void fileReader(String path) throws IOException {
		FileReader fr = new FileReader(path);
		int i = 0;
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
		fr.close();
	}

	public static void main(String[] args) throws Exception {
		String path = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		fileWriter(path);
		fileReader(path);
	}

}
