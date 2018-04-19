package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportCSVServiceTest {

    @Test
    public void export() throws IOException {
        ExportCSVService exportCSVService = new ExportCSVService();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        
        ClientDTO clientDTO1 = new ClientDTO();
        clientDTO1.setNom("PETRILLO");
        clientDTO1.setPrenom("Alexandre");
        clientDTOS.add(clientDTO1);
        
        ClientDTO clientDTO2 = new ClientDTO();
        clientDTO2.setNom("COLTRANE");
        clientDTO2.setPrenom("John");
        clientDTOS.add(clientDTO2);
        
        ClientDTO clientDTO3 = new ClientDTO();
        clientDTO3.setNom("DAVIS");
        clientDTO3.setPrenom("Miles");
        clientDTOS.add(clientDTO3);
        
        ClientDTO clientDTO4 = new ClientDTO();
        clientDTO4.setNom("MCLAUGHLIN");
        clientDTO4.setPrenom("John");
        clientDTOS.add(clientDTO4);
        
        ClientDTO clientDTO5 = new ClientDTO();
        clientDTO5.setNom("EVANS");
        clientDTO5.setPrenom("Bill");
        clientDTOS.add(clientDTO5);
        
        ClientDTO clientDTO6 = new ClientDTO();
        clientDTO6.setNom("CALE");
        clientDTO6.setPrenom("JJ");
        clientDTOS.add(clientDTO6);
        
        ClientDTO clientDTO7 = new ClientDTO();
        clientDTO7.setNom("COODER");
        clientDTO7.setPrenom("Ry");
        clientDTOS.add(clientDTO7);
        
        
        
        
        
        
       
        
        

        File tempFile = new File("./target/clientDTOS.csv");
        tempFile.createNewFile();
        FileWriter writer = new FileWriter(tempFile);

        exportCSVService.export(writer, clientDTOS);

        writer.close();
    }
}