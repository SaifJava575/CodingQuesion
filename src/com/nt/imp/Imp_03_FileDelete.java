package com.nt.imp;

import java.io.File;

public class Imp_03_FileDelete {

	public static void main(String[] args) {
		try {
			String str = "D:\\SaifuddinWorkSpace\\CompressFile\\demo.jpg";
			File file = new File(str);
			file.deleteOnExit();
			//file.delete();
			System.out.println("Done");

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
