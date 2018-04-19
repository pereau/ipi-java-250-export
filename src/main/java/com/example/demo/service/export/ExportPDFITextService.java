package com.example.demo.service.export;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ExportPDFITextService {
	
	
	
	public void export (OutputStream os, FactureDTO facture) throws IOException, DocumentException {
		Document document =  new Document();
		PdfWriter.getInstance(document, os);
		document.open();
		
		document.add(new Paragraph("Facture du client :"));
		document.add(new Paragraph(facture.getClient().getNom().toUpperCase()));
		document.add(new Paragraph(facture.getClient().getPrenom()));
		document.add(new Paragraph(facture.getClient().getAge().toString()));
		document.add(new Paragraph(facture.getClient().getCp().toString()));
		document.add(new Paragraph(facture.getClient().getCommune()));
		
		for (int index = 0; index < facture.getLigneFactures().size(); index++) {
			document.add(new Paragraph("Articles :"));
			document.add(new Paragraph(facture.getLigneFactures().get(index).getDesignation()));
			document.add(new Paragraph(facture.getLigneFactures().get(index).getPrixUnitaire().toString()));
			document.add(new Paragraph(facture.getLigneFactures().get(index).getQuantite().toString()));
		}
		
        document.close();
	
	

	}
	
}
