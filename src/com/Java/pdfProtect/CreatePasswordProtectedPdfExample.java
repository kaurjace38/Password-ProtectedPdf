package com.Java.pdfProtect;

import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class CreatePasswordProtectedPdfExample {
	
	  public static void main(String[] args) {
          try {
                 String pdfFilePath = "D:/Create Password Protected Pdf Example.pdf";

                 OutputStream fos = new FileOutputStream(new File(pdfFilePath));
                 Document document = new Document();
                 PdfWriter pdfWriter = PdfWriter.getInstance(document, fos);

                 String userPassword = "user_password";
                 String ownerPassword = "owner_password";

                 pdfWriter.setEncryption(userPassword.getBytes(),
                              ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
                              PdfWriter.ENCRYPTION_AES_128);

                 document.open();

                 document.add(new Paragraph("This is Password protected PDF file"));

                 document.close();
                 fos.close();

                 System.out.println("PDF created in >> " + pdfFilePath);

          } catch (Throwable e) {
                 e.printStackTrace();
          }
   }
}
