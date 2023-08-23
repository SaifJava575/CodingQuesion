package com.nt.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_14_BufferWriterAndReaderClass {

	public static void bufferWriter(String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Hello! Saifuddin How are you?");
		char ch[] = { 'a', 'b', 'c', 'd' };
		bw.write(ch, 0, 4);
		bw.close();

	}

	public static void bufferReader(String path) throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		int i = 0;
		while ((i = br.read()) != -1)
			System.out.print((char) i);
		br.close();
	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		bufferWriter(path);
		bufferReader(path);

	}

}
