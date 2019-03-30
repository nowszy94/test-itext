package com.szymon.pdfboxtest;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleTable {
    private static final String DEST = "itext-pdf.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        new SimpleTable().createPdf(DEST);
    }

    private void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4, 0, 0, 20, 0);

        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);

        for (int aw = 0; aw < 9; aw++) {
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setFixedHeight(260);
            pdfPCell.setPadding(20f);
            Image image = Image.getInstance("C:\\inzynierka\\pdfboxtest\\1.png");
            image.setAlignment(Element.ALIGN_CENTER);
            pdfPCell.addElement(image);
            Paragraph paragraph = new Paragraph("dupa du asdf sadf asdfas dfasfdioajo fijwofdi jasodifpa");
            Paragraph paragraph2 = new Paragraph("czy dobre jest?");
            paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
            paragraph2.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            pdfPCell.addElement(paragraph);
            pdfPCell.addElement(paragraph2);
            pdfPCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(pdfPCell);
        }
        Paragraph paragraph = new Paragraph("Bicie w przelocie - 21.03.2019");
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        document.add(table);

        document.close();
    }
}
