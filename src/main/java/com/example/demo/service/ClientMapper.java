package com.example.demo.service;



import org.springframework.stereotype.Component;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;


@Component
public class ClientMapper {
    public ClientDTO map(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setAge(entity.getAge());
        dto.setCp(entity.getCp());
        dto.setCommune(entity.getCommune());
        return dto;
    }
}
