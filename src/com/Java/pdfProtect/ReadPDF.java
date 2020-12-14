package com.Java.pdfProtect;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;


public class ReadPDF {


		  public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
		       PdfReader reader = new PdfReader("D:/NotProtectedPDF.pdf");
		       PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("D:/ProtectedPDF.pdf"));
		       stamper.setEncryption("password".getBytes(), "owner_password".getBytes(),PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_256);
		       stamper.close();
		       reader.close();
		       System.out.println("Successfully Done");
		}
		
}
