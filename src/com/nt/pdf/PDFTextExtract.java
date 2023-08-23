package com.nt.pdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTextExtract {

	public static void main(String[] args) {
		File pdf=new File("rev.pdf");
		try {
			PDDocument pdDocument=PDDocument.load(pdf);
			PDFTextStripper pdfTextStripper=new PDFTextStripper();
			String text=pdfTextStripper.getText(pdDocument);
			System.out.println(text);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
