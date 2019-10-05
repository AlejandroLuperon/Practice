package com.restageparser.app;

import org.apache.pdfbox.pdmodel.PDDocument;


import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;

import org.fit.pdfdom.PDFDomTree;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.w3c.dom.Document;

public class PDF2DomExperiment {
    public static void main(String[] args) {
        generateHTMLFromPDF("OWA17_ExhibitorProspectus.pdf");
    }
    private static void generateHTMLFromPDF(String filename) {
        try {
            PDDocument pdf = PDDocument.load(new File(PDF2DomExperiment.class.getClassLoader().getResource(filename).toURI()));
            Writer output = new PrintWriter("OWA17.html", "utf-8");
            new PDFDomTree().writeText(pdf, output);

            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
