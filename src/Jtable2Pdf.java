/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */

import com.lowagie.text.Anchor;
import com.lowagie.text.Chapter;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;




public class Jtable2Pdf extends JFrame{
    
    private JTable tabla;
    private String local;
    private String visitante;

  public Jtable2Pdf() {
    getContentPane().setLayout(new BorderLayout());
    
  }
    public void setJtable(JTable table){
        this.tabla = table;
    }
    public void print() throws DocumentException {
    /*Document document = new Document(PageSize.A4.rotate());
    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("jTable.pdf"));

      document.open();
      PdfContentByte cb = writer.getDirectContent();

      cb.saveState();
      Graphics2D g2 = cb.createGraphicsShapes(500, 500);

      Shape oldClip = g2.getClip();
      g2.clipRect(0, 0, 500, 500);

      table.print(g2);
      g2.setClip(oldClip);

      g2.dispose();
      cb.restoreState();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    document.close();*/
    
    
    
    Document document = new Document();
                    try {
                        PdfWriter.getInstance(document, new FileOutputStream(local+"vs"+visitante+ ".pdf"));
                    } catch (FileNotFoundException fileNotFoundException) {

                    }
                    document.open();

                    // First page (Primera pÃ¡gina)
                    Anchor anchor = new Anchor();
                    anchor.setName("");

                    // Second parameter is the number of the chapter (El segundo parámetro es el número del capí­tulo).
                    Chapter catPart = new Chapter(new Paragraph(anchor), 1);

                    Paragraph subPara = new Paragraph("");
                    Section subCatPart = catPart.addSection(subPara);
                    subCatPart.add(new Paragraph(""));

                    // Create the table (Creamos la tabla)
                    PdfPTable table = new PdfPTable(tabla.getColumnCount());

                    // Now we fill the rows of the PdfPTable (Ahora llenamos las filas de PdfPTable)
                    PdfPCell columnHeader;
                    // Fill table columns header 
                    // Rellenamos las cabeceras de las columnas de la tabla.                
                    for (int column = 0; column < tabla.getColumnCount(); column++) {
                        columnHeader = new PdfPCell(new Phrase(tabla.getColumnName(column)));
                        columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(columnHeader);
                    }
                    table.setHeaderRows(1);
                    // Fill table rows (rellenamos las filas de la tabla).                
                    for (int row = 0; row < tabla.getRowCount(); row++) {
                        for (int column = 0; column < tabla.getColumnCount(); column++) {
                            table.addCell(tabla.getValueAt(row, column).toString());
                        }
                    }
                    subCatPart.add(table);

                    document.add(catPart);

                    document.close();
                    this.setVisible(false);
  }
    
    
   
    
    
    
    
    
    
    
    
    
    
}
