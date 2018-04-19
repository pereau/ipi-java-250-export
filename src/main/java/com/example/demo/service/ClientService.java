package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;
import com.example.demo.repository.ClientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDTO> findAllClients() {
//    	List<Client> clients = clientRepository.findAll();
//    	List<ClientDTO> dtos = new ArrayList<>();
//    	for (Client client : clients) {
//    		ClientDTO dto =clientMapper.map(client);
//    		dtos.add(dto);
//    	}
//    	return dtos;
    	
        return clientRepository.findAll().stream().map(c-> clientMapper.map(c)).collect(toList());
        
    }
    
   
}
