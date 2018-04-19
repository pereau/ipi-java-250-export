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
		int num=1;
		for (FactureDTO factureDTO : factures) {
			
			String sheetName = "facture de  " + factureDTO.getClient().getNom() + " N°" + num;
			XSSFSheet onglet = workbook.createSheet(sheetName);
			Row headerRowOnglet = onglet.createRow(0);
			Cell cellClient = headerRowOnglet.createCell(0);
			cellClient.setCellValue("PRENOM");
			cellClient = headerRowOnglet.createCell(1);
			cellClient.setCellValue("NOM");
			Cell cellLigneFacture = headerRowOnglet.createCell(2);
			cellLigneFacture.setCellValue("ARTICLE");
			cellLigneFacture = headerRowOnglet.createCell(3);
			cellLigneFacture.setCellValue("PRIX UNITAIRE");
			cellLigneFacture = headerRowOnglet.createCell(4);
			cellLigneFacture.setCellValue("QUANTITE");
			
			Row row = onglet.createRow(1);
			Cell cellClientPrenom = row.createCell(0);
			cellClientPrenom.setCellValue(factureDTO.getClient().getPrenom());
			Cell cellClientNom = row.createCell(1);
			cellClientNom.setCellValue(factureDTO.getClient().getNom());
			cellLigneFacture = row.createCell(2);
		    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(num - 1).getDesignation());
		    cellLigneFacture = row.createCell(3);
		    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(num - 1).getPrixUnitaire());
		    cellLigneFacture = row.createCell(4);
		    cellLigneFacture.setCellValue(factureDTO.getLigneFactures().get(num - 1).getQuantite());
			
			
			num+=1;
		}
		
		workbook.write(outputStream);
		workbook.close();
		
	}

}