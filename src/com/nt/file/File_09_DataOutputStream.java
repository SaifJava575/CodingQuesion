package com.nt.file;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_09_DataOutputStream {

	public static void dataoutputStream(String path) throws IOException {
		FileOutputStream fot = new FileOutputStream(path);

		DataOutputStream dout = new DataOutputStream(fot);
		dout.writeInt(65);
		String str = "SK SAIFUDDIN";
		byte[] arr = str.getBytes();
		dout.write(arr);
		dout.writeChar(66);
		dout.writeBoolean(true);
		dout.writeChars(str);
		dout.writeDouble(102.00);
		dout.writeUTF(str);
		dout.flush();
		fot.close();
		dout.close();

	}

	public static void main(String[] args) throws IOException {
		String txt = "D:\\SaifuddinWorkSpace\\CompressFile\\info.txt";
		dataoutputStream(txt);

	}

}
