package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.LigneFacture;






@Component
public class LigneFactureMapper {
    public LigneFactureDTO map(LigneFacture entity) {
    	
    	LigneFactureDTO ligneFactureDto = new LigneFactureDTO();
    	
        ligneFactureDto.setDesignation(entity.getArticle().getLibelle());
        ligneFactureDto.setPrixUnitaire(entity.getArticle().getPrix());
        ligneFactureDto.setQuantite(entity.getQuantite());

     
        return ligneFactureDto;
    }
}
