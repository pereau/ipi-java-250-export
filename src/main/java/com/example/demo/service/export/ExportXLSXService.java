package com.example.demo.service.export;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.derby.iapi.services.daemon.DaemonService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.birt.report.model.metadata.DefaultAbsoluteFontSizeValueProvider;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.entity.LigneFacture;



@Service
public class ExportXLSXService {
	

	public static final int HEADER_SIZE = 1;
	
	
	public void export(OutputStream outputStream, List<ClientDTO> clients) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("clients");
		Row headerRow = sheet.createRow(0);
		Cell cellPrenom = headerRow.createCell(0);
		cellPrenom.setCellValue("Prénom");
		Cell cellNom = headerRow.createCell(1);
		cellNom.setCellValue("Nom");
		Cell cellAge = headerRow.createCell(2);
		cellAge.setCellValue("Age");
		Cell cellCp = headerRow.createCell(3);
		cellCp.setCellValue("Code Postal");
		Cell cellCommune = headerRow.createCell(4);
		cellCommune.setCellValue("Commune");
		
//		for (int index = 0; index < clients.size(); index++) {
//			ROW row1 = sheet.createRow(index + HEADER_SIZE);
//		}
		
		
		int num =1;
		for (ClientDTO clientDTO : clients) {
			
		
			headerRow = sheet.createRow(num);
			cellPrenom = headerRow.createCell(0);
			cellPrenom.setCellValue(clientDTO.getPrenom());
			cellNom = headerRow.createCell(1);
			cellNom.setCellValue(clientDTO.getNom());
			cellAge = headerRow.createCell(2);
			cellAge.setCellValue(clientDTO.getAge());
			cellCp = headerRow.createCell(3);
			cellCp.setCellValue(clientDTO.getCp());
			cellCommune = headerRow.createCell(4);
			cellCommune.setCellValue(clientDTO.getCommune());
			
			num+=1;
			
		}
				
		workbook.write(outputStream);
		workbook.close();
	}
	
	
	public void editFactureXLSX (OutputStream outputStream, List<FactureDTO> factures) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		int numFacture=1;
		int nbArticle = 0;
		Double total = 0.0;
		for (FactureDTO factureDTO : factures) {
			
			String sheetName = "facture de  " + factureDTO.getClient().getNom() + " N°" + numFacture;
			XSSFSheet onglet = workbook.createSheet(sheetName);
			Row headerRowOnglet = onglet.createRow(0);
			Cell cellClient = headerRowOnglet.createCell(0);
			cellClient.setCellValue("PRENOM");
			cellClient = headerRowOnglet.createCell(1);
			cellClient.setCellValue("NOM");
			
			
			
			Row row = onglet.createRow(1);
			Cell cellClientPrenom = row.createCell(0);
			cellClientPrenom.setCellValue(factureDTO.getClient().getPrenom());
			Cell cellClientNom = row.createCell(1);
			cellClientNom.setCellValue(factureDTO.getClient().getNom());
			
			Row headerRow2 = onglet.createRow(3);
			Cell cellLigneFacture = headerRow2.createCell(0);
			cellLigneFacture.setCellValue("ARTICLE");
			cellLigneFacture = headerRow2.createCell(1);
			cellLigneFacture.setCellValue("PRIX UNITAIRE");
			cellLigneFacture = headerRow2.createCell(2);
			cellLigneFacture.setCellValue("QUANTITE");
			int n = factureDTO.getLigneFactures().size();
			System.out.println(n);
			for (int numLigne = 1 ; numLigne <= n  ; numLigne++) {
				nbArticle += 1;
				System.out.println(factureDTO.getLigneFactures().get(numLigne - 1).getDesignation());
				System.out.println(numLigne -1);
				System.out.println(factureDTO.getId());
				Row rowLf = onglet.createRow(numLigne +3);
				cellLigneFacture = rowLf.createCell(0);
			    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(numLigne - 1).getDesignation());
			    cellLigneFacture = rowLf.createCell(1);
			    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(numLigne - 1).getPrixUnitaire());
			    cellLigneFacture = rowLf.createCell(2);
			    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(numLigne - 1).getQuantite());
			    
			    total += factureDTO.getLigneFactures().get(numLigne - 1).getPrixUnitaire()*factureDTO.getLigneFactures().get(numLigne - 1).getQuantite();
			    
			    
			    
			}
			
			numFacture+=1;
		}
		
		XSSFSheet prixTotal = workbook.createSheet("Prix Total");
		Row headerTotal = prixTotal.createRow(0);
		Cell cell1 = headerTotal.createCell(0);
		cell1.setCellValue("Nombre  total d'articles");
		Cell cell2 = headerTotal.createCell(1);
		cell2.setCellValue("Prix  total");
		cell2 = headerTotal.createCell(2);
		Row rowTotal = prixTotal.createRow(1);
		Cell cell3 = rowTotal.createCell(0);
		cell3.setCellValue(nbArticle);
		Cell cell4 = rowTotal.createCell(1);
		cell4.setCellValue(total);
		
		
		
		workbook.write(outputStream);
		workbook.close();
		
	}

}