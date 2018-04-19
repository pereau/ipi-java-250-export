package com.example.demo.service.export;

import java.io.IOException;
import java.io.OutputStream;


import org.springframework.stereotype.Service;


import com.example.demo.dto.FactureDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class ExportPDFITextService {
	
	
	
	public void export (OutputStream os, FactureDTO facture) throws IOException, DocumentException {
		Document document =  new Document();
		PdfWriter.getInstance(document, os);
		document.open();
		
		document.add(new Paragraph("Facture du client :"));
		PdfPTable tableClient = new PdfPTable(5); // 3 colonnes.
		PdfPCell cellc1 = new PdfPCell(new Paragraph("Nom"));
		PdfPCell cellc2 = new PdfPCell(new Paragraph("Prénom"));
		PdfPCell cellc3 = new PdfPCell(new Paragraph("Age (années)"));
		PdfPCell cellc4 = new PdfPCell(new Paragraph("Code postale"));
		PdfPCell cellc5 = new PdfPCell(new Paragraph("Commune"));
		tableClient.addCell(cellc1);
		tableClient.addCell(cellc2);
		tableClient.addCell(cellc3);
		tableClient.addCell(cellc4);
		tableClient.addCell(cellc5);
		
		PdfPCell cellc11 = new PdfPCell(new Paragraph(facture.getClient().getNom().toUpperCase())); 
		PdfPCell cellc12 = new PdfPCell(new Paragraph(facture.getClient().getPrenom())); 
		PdfPCell cellc13 = new PdfPCell(new Paragraph(facture.getClient().getAge().toString())); 
		PdfPCell cellc14 = new PdfPCell(new Paragraph(facture.getClient().getCp().toString())); 
		PdfPCell cellc15 = new PdfPCell(new Paragraph(facture.getClient().getCommune())); 
		tableClient.addCell(cellc11);
		tableClient.addCell(cellc12);
		tableClient.addCell(cellc13);
		tableClient.addCell(cellc14);
		tableClient.addCell(cellc15);
		
		
		
		document.add(tableClient);
		
		PdfPTable table = new PdfPTable(3); // 3 colonnes.

        ;

        
        document.add(new Paragraph("Articles :"));
       
		
        PdfPCell cell01 = new PdfPCell(new Paragraph("Designation de l'article"));
        PdfPCell cell02 = new PdfPCell(new Paragraph("Prix unitaire"));
        PdfPCell cell03 = new PdfPCell(new Paragraph("Quantité"));
        table.addCell(cell01);
		table.addCell(cell02);
		table.addCell(cell03);
		Double total = 0.0;
		for (int index = 0; index < facture.getLigneFactures().size(); index++) {
			
			
			PdfPCell cell1 = new PdfPCell(new Paragraph(facture.getLigneFactures().get(index).getDesignation()));
			table.addCell(cell1);
			PdfPCell cell2 = new PdfPCell(new Paragraph(facture.getLigneFactures().get(index).getPrixUnitaire().toString()));
			table.addCell(cell2);
			PdfPCell cell3 = new PdfPCell(new Paragraph(facture.getLigneFactures().get(index).getQuantite().toString()));
			table.addCell(cell3);
			
			total += facture.getLigneFactures().get(index).getQuantite()*facture.getLigneFactures().get(index).getPrixUnitaire();
			
			
		}
		
		document.add(table);
		
		PdfPTable tableTotal = new PdfPTable(2);
		
		PdfPCell cellTot1 = new PdfPCell(new Paragraph("Prix total"));
		PdfPCell cellTot2 = new PdfPCell(new Paragraph(total.toString()));
		tableTotal.addCell(cellTot1);
		tableTotal.addCell(cellTot2);
		document.add(tableTotal);
		
        document.close();
	
	

	}
	
}
