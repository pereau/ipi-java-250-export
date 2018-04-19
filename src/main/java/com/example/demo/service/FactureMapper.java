package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;




@Component
public class FactureMapper {
    public FactureDTO map(Facture entity) {
    	Client client = entity.getClient();
    	ClientMapper clientMapper = new ClientMapper();
    	ClientDTO clientDTO = clientMapper.map(client);
        
    	FactureDTO factureDto = new FactureDTO();
        factureDto.setClient(clientDTO);
//       dto.setLigneFactures(entity.getLigneFactures());
     
        return factureDto;
    }
}
