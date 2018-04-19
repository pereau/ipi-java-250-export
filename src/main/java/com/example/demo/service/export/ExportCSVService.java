package com.example.demo.service.export;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;



@Service
public class ExportCSVService {
	
	
	public void export(Writer printWriter, List<ClientDTO> clients) throws IOException {
	
		printWriter.write("Nom;Prenom;Age;Code Postal;Commune");
		printWriter.write("\n");
		for (ClientDTO clientDTO : clients) {
			printWriter.write(replace(clientDTO.getNom()));
			printWriter.write(";");
			printWriter.write(replace(clientDTO.getPrenom()));
			printWriter.write(";");
			printWriter.write(replace(clientDTO.getAge().toString()));
			printWriter.write(";");
			printWriter.write(replace(clientDTO.getCp().toString()));
		    printWriter.write(";");
			printWriter.write(replace(clientDTO.getCommune()));
			printWriter.write(";");
		printWriter.write("\n");
			
		}
	}
	
	private String replace (String value) {
		value = value.replace("\"", "\"\"");
		if (value.contains(";")) {
			value = "\"" + value + "\"";
		} 
		return value;
	}

}
