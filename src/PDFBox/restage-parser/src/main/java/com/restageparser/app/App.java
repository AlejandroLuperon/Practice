package com.restageparser.app;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class App {

    public static void main(String args[]) throws IOException {
        try {
            //Loading an existing document
            System.out.println(App.class.getClassLoader().getResource("esri.pdf").toURI());
            File file = new File(App.class.getClassLoader().getResource("esri.pdf").toURI());
            PDDocument document = PDDocument.load(file);

            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();

            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);
            System.out.println(text);

            //Closing the document
            document.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}